public class Source {
    public static void main(String[] args) {

        // New deck initialization.
        Deck deck = new Deck();

        // Players initialization.
        Player playerNeung = new Player();
        Player playerSom = new Player();
        Player playerSam = new Player();
        Player playerSi = new Player();

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

        // Find 3 of spades.
        // deck.findThreeOfSpades(null, null, null, null, null, args);

        // Cards on the table initialization.
        // ArrayList<String> cardsPlayed = new ArrayList<>();

        // System.out.println("Player's deck of cards update:");
        // printCards(playerOne, playerTwo, playerThree, playerFour);
    }


    // 1. find 3 of spades method:
    // - go through all of the player's deck, 
    //  + compare each every element of that player's deck to the string "3 of Spades" to see which player has it. 
    //  + if we have found the player then the "3 of Spades" from that player's deck will be gone.
    // - deleted card will be printed.
    // - print the cards from the players again.

    // SWITCH EVERYTHING TO OBJECTS NOW.
    // 2. move the turn to the next player
    // 3. player dealts card if the card they wanna deal is larger than the card before it.
    // 4. show the card that has been dealt
    // 5. update the player's card deck
    // 6. move the turn to the next player and keep going for the cycle.

    // extra brainstorm done: when you check the card that is on the table and the card that the player wanna deal, you would only 
    // need two Strings, an array is unnecessary cause you're comparing those two Strings. the card of the player can only be dealt 
    // if is bigger than the other one.
    // you can either use your turn to play the card or pass it to the next person.
    // only show the last two cards in the cardsPlayed arraylist.
    // find a way to store a whole sort of array? inside arraylist. cause what if a player plays a whole sequence? therefore we cant
    // use just two strings, cause what if its a whole sequence?

    // ideas for switching this to OOP:
    // - deck class
    //  + initialize the deck in there, have getters so you can have access to the indexes
    //  + shuffle cards method
    //  + sort cards method

    // what can that player class has so that we can create player instances?
    // - create a class for players. then inside the Source.java, make 4 instances from that class.
    //  + Player player1 = new Player() etc,.
    //  + the Player class will hold an array list of strings. 
    //    => we will have a method that can add the cards into the Player's array list of string.
    //    => we will also have a method that can remove the cards from the Player's array list of string.
    //  + find 3 of Spades method
    //

    // Check discord message via michael.
}
