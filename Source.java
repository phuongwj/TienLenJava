import java.util.ArrayList;
import java.util.Scanner;

public class Source {
    public static void main(String[] args) {

        // Scanner initialization.
        Scanner in = new Scanner(System.in);

        // New deck initialization.
        Deck deck = new Deck();

        // Turn manager initialization.
        RoundAndRound turnManager = new RoundAndRound();

        // An array of Players.
        ArrayList<Player> players = new ArrayList<>(4);

        // Individual Players initialization.
        for (int i = 0; i < 4; i++) {
            players.add(new Player());
            players.get(i).setPlayerId();
        }

        // Player calls shuffle deck method.
        Player.shuffleDeck(deck);

        // Adding shuffled deck into Players' hands.
        for (int i = 0; i < 52; i++) {
            int currPlayer = i / 13;
            players.get(currPlayer).addDeckShuffled(i, deck);
        }

        // Sorting cards low to high for 4 Players.
        for (int i = 0; i < 4; i++) {
            players.get(i).sortCards(deck);
        }

        // After sorted.
        System.out.println("After sorted:" + "\n");
        deck.printCardsInHandAll(players);

        // Find 3 of Spades.
        System.out.println("Find 3 of Spades:" + "\n");
        deck.findThreeOfSpades(players);
        turnManager.rotateTurns(deck.getIndexThreeOfSpades(), players);
        System.out.println("Player " + (deck.getIndexThreeOfSpades() + 1) + " has 3 of Spades, so they get to deal card first.");

        // Players cards in hand after 3 of Spades.
        deck.printCardsInHandAll(players);

        String deal = "";
        int rounds = 0;
        int totalNumOfPasses = 0;

        while ( !(deck.gameHasEnded(players)) ) {

            if (rounds < 1) {

                for (int i = 0; i < players.size(); i++) {
                    
                    // Only executes at the initial round where "the" player has 3 of Spades.
                    if (players.get(i).getCardsInHand().contains("3 of Spades")) {
                        players.get(i).dealCard("3 of Spades", deck);
                        players.get(i).setHas3OfSpades(false);
                        System.out.println("Player " + players.get(i).getPlayerId() + " has dealt 3 of Spades.");
                        System.out.println("Cards on the table: " + deck.getCardsPlayed() + "\n");
                        continue;
                    }

                    // If player's cards in hand is empty.
                    if (players.get(i).getCardsInHand().isEmpty()) {
                        players.remove(i);
                        continue;
                    }

                    // Deal or Pass.
                    System.out.println("Player " + players.get(i).getPlayerId() + " please either insert \"Pass\" to pass your turn or insert a card from your hand to deal it. " + "\n" + "Here are your cards in hand." + "\n");
                    deck.printCardsInHand(players.get(i));
                    deal = in.nextLine();

                    if (deal.equals("Pass")) {
                        totalNumOfPasses++;
                        players.get(i).setHasDealtCard(false);
                        System.out.println("Player " + players.get(i).getPlayerId() + " has passed their turn.");
                        System.out.println("Cards on the table: " + deck.getCardsPlayed() + "\n");
                        continue;

                    } else {
                        
                        players.get(i).dealCard(deal, deck);

                        while (players.get(i).invalidCard()) {
                            deal = in.nextLine();
                            players.get(i).dealCard(deal, deck);

                            if (deal.equals("Pass")) {
                                totalNumOfPasses++;
                                players.get(i).setHasDealtCard(false);
                                System.out.println("Player " + players.get(i).getPlayerId() + " has passed their turn.");
                                System.out.println("Cards on the table: " + deck.getCardsPlayed() + "\n");
                                break;
                            }
                        }

                        System.out.println("Player " + players.get(i).getPlayerId() + " has dealt " + deal + ".");
                        System.out.println("Cards on the table: " + deck.getCardsPlayed() + "\n");
                        continue;
                    }
                }
            } 

            if (rounds >= 1) {

                for (int i = 0; i < players.size(); i++) {

                    // If player has dealt card in the first round then they get to play.
                    if (players.get(i).hasDealtCard()) {
                        System.out.println("Player " + players.get(i).getPlayerId() + " please either insert \"Pass\" to pass your turn or insert a card from your hand to deal it. " + "\n" + "Here are your cards in hand." + "\n");
                        deck.printCardsInHand(players.get(i));
                        deal = in.nextLine();

                        if (deal.equals("Pass")) {
                            totalNumOfPasses++;
                            players.get(i).setHasDealtCard(false);
                            System.out.println("Player " + players.get(i).getPlayerId() + " has passed their turn.");
                            System.out.println("Cards on the table: " + deck.getCardsPlayed() + "\n");
                            continue;

                        } else {

                            players.get(i).dealCard(deal, deck);

                            while (players.get(i).invalidCard()) {
                                deal = in.nextLine();
                                players.get(i).dealCard(deal, deck);

                                if (deal.equals("Pass")) {
                                    totalNumOfPasses++;
                                    players.get(i).setHasDealtCard(false);
                                    System.out.println("Player " + players.get(i).getPlayerId() + " has passed their turn.");
                                    System.out.println("Cards on the table: " + deck.getCardsPlayed() + "\n");
                                    break;
                                }
                            }

                            System.out.println("Player " + players.get(i).getPlayerId() + " has dealt " + deal + ".");
                            System.out.println("Cards on the table: " + deck.getCardsPlayed() + "\n");
                            continue;
                        }
                    }
                }
            }
        }
    }
}
