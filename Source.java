import java.util.ArrayList;

public class Source {
    public static void main(String[] args) {

        // New deck initialization.
        Deck deck = new Deck();

        // An array of Players.
        ArrayList<Player> players = new ArrayList<>(4);
        // ArrayList<Player> players2 = new ArrayList<>(4);

        // Individual Players initialization.
        for (int i = 0; i < 4; i++) {
            players.add(new Player());
            // players2.add(new Player());
        }

        Player.callShuffleDeck();

        // Adding shuffled deck into Players' hands.
        for (int i = 0; i < 52; i++) {
            int currPlayer = i / 13;
            players.get(currPlayer).addDeckShuffled(i);
            // players2.get(currPlayer).addDeckShuffled(i);
        }

        // for (int i = 0; i < 13; i++) {
        //     players.get(0).addDeckShuffled(i);
        // }

        // for (int i = 13; i < 26; i++) {
        //     players.get(1).addDeckShuffled(i);
        // }

        // for (int i = 26; i < 39; i++) {
        //     players.get(2).addDeckShuffled(i);
        // }

        // for (int i = 39; i < 52; i++) {
        //     players.get(3).addDeckShuffled(i);
        // }

        // for (int i = 0; i < 4; i++) {
        //     for (int j = 0; j < 13; j++) {
        //         System.out.println(players.get(i).getCardsInHand().get(j));
        //     }
        //     System.out.println();
        // }

        // for (int i = 0; i < 4; i++) {
        //     players.get(i).sortCards();
        // }

        // System.out.println("-------------------");
        // for (int i = 0; i < 4; i++) {
        //     for (int j = 0; j < 13; j++) {
        //         System.out.println(players.get(i).getCardsInHand().get(j));
        //     }
        //     System.out.println();
        // }

        // Before sorted.
        System.out.println("Before sorted:");
        System.out.println();
        System.out.println("Player 1");
        deck.printCardsInHand(players);

        // Sorting cards low to high for 4 Players.
        for (int i = 0; i < 4; i++) {
            players.get(i).sortCards();
        }

        // After sorted.
        System.out.println("After sorted:");
        System.out.println();
        System.out.println("Player 1");
        deck.printCardsInHand(players);

        // // Find 3 of Spades.
        // System.out.println("Find 3 of Spades");
        // System.out.println();
        // System.out.println("Player 1");
        // deck.findThreeOfSpades(players);

        // System.out.println("First player: ");
        // for (int i = 0; i < 13; i++) {
        //     System.out.println(players.get(0).getCardsInHand().get(i));
        // }
        // System.out.println("-----------------");
        // System.out.println("Second player: ");
        // for (int i = 0; i < 13; i++) {
        //     System.out.println(players.get(1).getCardsInHand().get(i));
        // }
    }

    // Can consider where there are atleast two players playing against each other. This is for further notice 
    // when you have options for multiplayers in the game.

    // 1. Switch the individual Player to an array that can hold classes.
    //   + create method that can remove the cards from the Player's array list of strings.
    //     => You don't have to write this because you can just get the whole array then do .remove() in the main class or somewhere that you wanna remove it.
    // 2. Find 3 of Spades method only for the first game.
    // 3. Do the rotation thingy.
    // 4. Deal the cards.
    // 5. Remove the cards that the player 
    // 5. Figure out how you would keep track of who finishes the game before first so that the next game, that 
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
}
