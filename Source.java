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

                // If atleast 3 players have "Pass" their turns, then let the player that 
                // recently dealt be first to deal their cards for the next round.
                if (totalNumOfPasses > 2) {

                    System.out.println("Since there have been 3 players that decided to \"Pass\" their turns, so a new round will start.");
                    System.out.println("Cards on the table will also be removed.");
                    deck.clearCardsPlayed();
                    rounds = 0;

                    for (int i = 0; i < players.size(); i++) {
                        if (players.get(i).hasDealtCard()) {
                            System.out.println("Player " + players.get(i).getPlayerId() + " is the Player that dealt their card most recent, so they will get to be the first to deal any cards in their hand. " + "\n");
                            turnManager.rotateTurns(i, players);
                            break;
                        }
                    }

                    totalNumOfPasses = 0;

                } else {
                    rounds++;
                }
            } 

            

            if (rounds >= 1) {

                for (int i = 0; i < players.size(); i++) {

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
                
                // If atleast 3 players have "Pass" their turns, then let the player that 
                // recently dealt be first to deal their cards for the next round.
                if (totalNumOfPasses > 2) {

                    System.out.println("Since there have been 3 players that decided to \"Pass\" their turns, so a new round will start.");
                    System.out.println("Cards on the table will also be removed.");
                    deck.clearCardsPlayed();
                    rounds = 0;

                    for (int i = 0; i < players.size(); i++) {
                        if (players.get(i).hasDealtCard()) {
                            System.out.println("Player " + players.get(i).getPlayerId() + " is the Player that dealt their card most recent, so they will get to be the first to deal any cards in their hand. " + "\n");
                            turnManager.rotateTurns(i, players);
                            break;
                        }
                    }

                    totalNumOfPasses = 0;

                } else {
                    rounds++;
                }
            }
        }
    }


    // Brainstorm a way to keep count of "Pass" and exits the for loop right away when the count immediately reaches 3. So that whenever we "Pass", the game won't continue.
    // If we do "continue" for passing, we won't be able to grab the correct player that has just recently played. Maybe just have one

    // So say we call the findThreeOfSpades method. That method will only find 3 of Spades, in order to re-order the array list to determine who's going first. 
    // Start the inner for loop: 
    // The first if condition will be that to check if player at index 0 has 3 of Spades, which ideally should because we pushed it to the array list already.
    // If the player has it then we will force that player to play 3 of Spades and then we will move on to int i = 1. So on and so on. A for loop that starts from 0 to < 4.
    // Throughout the loop, if the player plays then set the hasDealtCard boolean to true.
    // So in the second for loop, we're gonna have an if statement at every single index to see that if they have the boolean dealtTheCard set to true. If it's true then they
    // get to play, if it's not true then they don't get to play, if it's their turn and they say that they're gonna pass the turn then we also set their boolean dealtTheCard 
    // to false. 
    // For the outer loop:
    // This is going to be a while loop, we don't know what the condition will be yet, but there's gonna be a counter. We're going to be having two for loops inside the
    // while loop. The if condition that execute the first for loop will be if counter = 0 (i.e indicating that its the first round and will decide the hasDealtCard boolean).
    // The second for loop will be executed if the counter is larger than 0 (meaning that after 1 rotation of the players playing their cards, another rotation starts again).
    
    // Check notes.


    // Can consider where there are atleast two players playing against each other. This is for further notice 
    // when you have options for multiplayers in the game.

    // 1. Switch the individual Player to an array that can hold classes.
    //   + create method that can remove the cards from the Player's array list of strings.
    //     => You don't have to write this because you can just get the whole array then do .remove() in the main class or somewhere that you wanna remove it.
    // 2. Find 3 of Spades method only for the first game.
    // 3. Do the rotation thingy.
    // 4. Deal the cards.
    // 5. Pass turn.
    // 6. Remove the cards that the player has dealt (Can be done inside the dealCard method).
    // 7. Figure out how you would keep track of who finishes the game before first so that the next game, that 
    //    person will get to deal the cards first. 

    // Like say we have player[2] came in first, player[1] came in second. What's the scoring system?
    //  - Scoring system: 3 points for coming first, 2 points for coming in second, 1 point for coming in third.
    //  - How do we keep the scores for each individual players?
    //    + We have a counter method and does ++ base on what place they came in. 
    //      => Base on the system to determine who finishes their cards first and after.
    //  - According to [1] down below, once we have set that Player's boolean to true. 
    
    // How to have a system to determine who finishes their cards first? 
    //  - Keeps a log of who came in first so that the next round if the players do agree to keep playing based on the previous round then the
    //    player who came in first will go first for the next round. No more 3 of Spades for every single round. 
    //    + Set boolean to true to the person that came in first, all Players have their boolean set to false, and when they finishes first, it will be set to true.
    //      => How do we determine if they're the FIRST to finish? After every single card that the Player has dealt, we check the cards in their hands to see if 
    //         they have an empty array list, if they do. We set that boolean to true for that Player, indicating that they're first. [1]

    // Either have a 3 booleans for comesInFirst, comesInSecond, comesInThird or have an array list that pushes Players in order of whos coming in first, second, third, last.

    // boolean for turns

     
}
