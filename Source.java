public class Source {
    public static void main(String[] args) {

        // New deck initialization.
        Deck deck = new Deck();

        // Players initialization.
        Player playerNeung = new Player();
        Player playerSom = new Player();
        Player playerSam = new Player();
        Player playerSi = new Player();

        // An array of Players initialization.
        Player[] player = new Player[4];

        for (int i = 0; i < 13; i++) {
            playerNeung.addDeckShuffled(i);
        }
        
        for (int i = 13; i < 26; i++) {
            playerSom.addDeckShuffled(i);
        }

        for (int i = 26; i < 39; i++) {
            playerSam.addDeckShuffled(i);
        }
    
        for (int i = 39; i < 52; i++) {
            playerSi.addDeckShuffled(i);
        }

        // Before sorted.
        System.out.println("Before sorted:");
        System.out.println();
        deck.printCards(playerNeung, playerSam, playerSi, playerSom);

        // Sorting cards low to high.
        deck.sortCards(playerNeung.getCardsInHand());
        deck.sortCards(playerSom.getCardsInHand());
        deck.sortCards(playerSam.getCardsInHand());
        deck.sortCards(playerSi.getCardsInHand());

        // After sorted.
        System.out.println("After sorted:");
        System.out.println();
        deck.printCards(playerNeung, playerSam, playerSi, playerSom);
    }

    // Can consider where there are atleast two players playing against each other. This is for further notice 
    // when you have options for multiplayers in the game.

    // 1. Switch the individual Player to an array that can hold classes.
    //   + create method that can remove the cards from the Player's array list of strings.
    // 2. Find 3 of Spades method only for the first game.
    // 3. Do the rotation thingy.
    // 4. Deal the cards.
    // 5. Figure out how you would keep track of who finishes the game before first so that the next game, that 
    //    person will get to deal the cards first. 
}
