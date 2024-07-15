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

        // Printing the players' cards (unsorted).
        System.out.println("UNSORTED");
        printCards(playerOne);
        printCards(playerTwo);
        printCards(playerThree);
        printCards(playerFour);

        //Sort cards low to high.
        sortCards(playerOne, deck);
        sortCards(playerTwo, deck);
        sortCards(playerThree, deck);
        sortCards(playerFour, deck);

        // Printing the players' cards (sorted).
        System.out.println("SORTED");
        printCards(playerOne);
        printCards(playerTwo);
        printCards(playerThree);
        printCards(playerFour);
    }

    // Method: Shuffle cards.
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

    // Method: Printing cards.
    public static void printCards(ArrayList<String> player) {
        for (int i = 0; i < 13; i++) {
            System.out.println(player.get(i));
        }
        System.out.println("-------------");
    }

    // Method: Sorting the cards low to high using Insertion Sort.
    public static void sortCards(ArrayList<String> player, String[] deck) {

        // Loop through the player's deck.
        for (int i = 1; i < player.size(); i++) {

            // Created two temporary variables that hold the real card value from the 52 card deck of the player's deck.
            int tempIndexFirst = 0;
            int tempIndexTwo = 0;

            // Have a temporary string to get the index 1 of player's card. (Aka, current index going through from i).
            String tempOne = player.get(i);

            // Previous index of the current index.
            int tempTwo = i-1;

            // Getting the real values of the player's cards from the 52-card deck.
            for (int j = 0; j < deck.length; j++) {
                if (player.get(i).equals(deck[j])) {
                    tempIndexFirst = j;
                    break;
                }
            }
            for (int k = 0; k < deck.length; k++) {
                if (player.get(tempTwo).equals(deck[k])) {
                    tempIndexTwo = k;
                    break;
                }
            }

            // Compares the indexes from the player's deck by using the real values received from the 52 deck to see which one comes first.
            while (tempTwo >= 0 && tempIndexTwo > tempIndexFirst) {
                player.set(tempTwo + 1, player.get(tempTwo));
                tempTwo--; 

                // Reset tempIndexTwo so that after 1 or more loops, when the previous cards are still larger than the "i" card. So we can keep
                // comparing. But only compare when tempTwo isn't negative. (Aka, out of bounds).
                if (!(tempTwo < 0)) {
                    for (int l = 0; l < deck.length; l++) {
                        if (player.get(tempTwo).equals(deck[l])) {
                            tempIndexTwo = l;
                            break;
                        }
                    }
                }
            }
            player.set(tempTwo + 1, tempOne);
        }
    }

    // have players play the card they want => show the card that has been dealt.
    // => update the card deck and have that card be dealt once they play it.
    // first game ever, identify which deck has 3 of spades.

}
