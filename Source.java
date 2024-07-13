import java.util.ArrayList;

public class Source {
    public static void main(String[] args) {

        // Deck of cards initialization. 
        String[] deck = {"3 of Spades", "3 of Clubs", "3 of Diamonds", "3 of Hearts",
                         "4 of Spades", "4 of Clubs", "4 of Diamonds", "4 of Hearts",
                         "5 of Spades", "5 of Clubs", "5 of Diamonds", "5 of Hearts",
                         "6 of Spades", "6 of Clubs", "6 of Diamonds", "6 of Hearts",
                         "7 of Spades", "7 of Clubs", "7 of Diamonds", "7 of Hearts", 
                         "8 of Spades", "8 of Clubs", "8 of Diamonds", "8 of Hearts", 
                         "9 of Spades", "9 of Clubs", "9 of Diamonds", "9 of Hearts",
                         "10 of Spades", "10 of Clubs", "10 of Diamonds", "10 of Hearts", 
                         "J of Spades", "J of Clubs", "J of Diamonds", "J of Hearts", 
                         "Q of Spades", "Q of Clubs", "Q of Diamonds", "Q of Hearts", 
                         "K of Spades", "K of Clubs", "K of Diamonds", "K of Hearts",
                         "A of Spades", "A of Clubs", "A of Diamonds", "A of Hearts",
                         "2 of Spades", "2 of Clubs", "2 of Diamonds", "2 of Hearts"};

        // Call shuffle cards method.
        ArrayList<String> deckShuffled = shuffleCards(deck);

        // Players initialization.
        ArrayList<String> playerOne = new ArrayList<>();
        ArrayList<String> playerTwo = new ArrayList<>();
        ArrayList<String> playerThree = new ArrayList<>();
        ArrayList<String> playerFour = new ArrayList<>();

        // Distributing the deck of cards into 4 hands (different all 4).
        for (int i = 0; i < 13; i++) {
            playerOne.add(deckShuffled.get(i));
        }

        for (int i = 13; i < 26; i++) {
            playerTwo.add(deckShuffled.get(i));
        }

        for (int i = 26; i < 39; i++) {
            playerThree.add(deckShuffled.get(i));
        }

        for (int i = 39; i < 52; i++) {
            playerFour.add(deckShuffled.get(i));
        }

        // Printing the players' cards.
        printCards(playerOne);
        printCards(playerTwo);
        printCards(playerThree);
        printCards(playerFour);
    }

    // Shuffle cards method.
    public static ArrayList<String> shuffleCards(String[] deck) {

        // ArrayList deck of cards initialization.
        ArrayList<String> deckShuffled = new ArrayList<String>();
        for (int i = 0; i < deck.length; i++) {
            deckShuffled.add(deck[i]);
        }

        // Shuffle deck of cards.
        for (int i = 0; i < 52; i++) {
            int n = i + ( (int) (Math.random() * (52 - i)) );

            String temp = deckShuffled.get(i);
            deckShuffled.set(i, deckShuffled.get(n) );
            deckShuffled.set(n, temp);
        }
        return deckShuffled;
    }

    // Printing cards method.
    public static void printCards(ArrayList<String> player) {
        for (int i = 0; i < 13; i++) {
            System.out.println(player.get(i));
        }
        System.out.println("-------------");
    }

    // Sorting the cards low to high method.
    public static void reOrderCards(ArrayList<String> player) {
        
    }

    // sort the cards from low to high within the player's deck.
    // - have a ranking system so as to sort the card accodingly.
    // => go through every single element of each individual hand. since its a string
    // so you have to use charAt() the first one for that string. and since you have 
    // the ordering of the numbers and suits in ascending order then the higher the 
    // index, the larger the value of the that particular number/suit. for example:
    // 5 is larger than 3, but 3 is also in a bigger index (aka 2 > 0). so we will 
    // check the index of each one to see which one is bigger. we will use a sorting
    // algorithm here. 

    // have players play the card they want => show the card that has been dealt.
    // => update the card deck and have that card be dealt once they play it.
    // only show the deck of cards thats associated to that player's turn.
    // first game ever, identify which deck has 3 of spades.


}
