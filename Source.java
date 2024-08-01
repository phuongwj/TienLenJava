public class Source {
    public static void main(String[] args) {

        // New deck initialization.
        Deck deck = new Deck();

        // An array of Players.
        Player[] player = new Player[4];

        // Individual Players initialization.
        for (int i = 0; i < 4; i++) {
            player[i] = new Player();
        }

        // Adding shuffled deck into Players' hands.
        for (int i = 0; i < 52; i++) {
            int currPlayer = i / 13;
            player[currPlayer].addDeckShuffled(i); 
        }

        // Before sorted.
        System.out.println("Before sorted:");
        System.out.println();
        deck.printCards(player);

        // Sorting cards low to high for 4 Players.
        for (int i = 0; i < 4; i++) {
            player[i].sortCards();
        }

        // After sorted.
        System.out.println("After sorted:");
        System.out.println();
        deck.printCards(player);
    }

    // Can consider where there are atleast two players playing against each other. This is for further notice 
    // when you have options for multiplayers in the game.

    // 1. Switch the individual Player to an array that can hold classes.
    //   + create method that can remove the cards from the Player's array list of strings.
    //     => You don't have to write this because you can just get the whole array then do .remove() in the main class or somewhere that you wanna remove it.
    // 2. Find 3 of Spades method only for the first game.
    // 3. Do the rotation thingy.
    // 4. Deal the cards.
    // 5. Figure out how you would keep track of who finishes the game before first so that the next game, that 
    //    person will get to deal the cards first. 

    // DONE: 1.
}
