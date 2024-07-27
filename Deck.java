import java.util.ArrayList;

public class Deck {
    private String[] deck;
    private ArrayList<String> deckShuffled;

    // Constructors.
    public Deck() {
        this.deck = new String[] {
            "3 of Spades", "3 of Clubs", "3 of Diamonds", "3 of Hearts",
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
            "2 of Spades", "2 of Clubs", "2 of Diamonds", "2 of Hearts"
        };
        this.deckShuffled = new ArrayList<>();
    }

    // Getters:

    // Gets deck.
    public String[] getDeckCard() {
        return deck;
    }

    // Gets shuffled deck.
    public String getDeckShuffled(int i) {
        return this.deckShuffled.get(i);
    }

    // Methods:

    // Method: Shuffle deck.
    public void shuffleDeck() {

        // ArrayList deck of cards initialization.
        for (int i = 0; i < this.deck.length; i++) {
            this.deckShuffled.add(this.deck[i]);
        }

        // Shuffle deck of cards.
        for (int i = 0; i < 52; i++) {
            int n = i + ( (int) (Math.random() * (52 -i)) );
            
            String temp = this.deckShuffled.get(i);
            this.deckShuffled.set(i, this.deckShuffled.get(n) );
            this.deckShuffled.set(n, temp);
        }
    }

    // Method: Sorting the cards low to high using Insertion Sort.
    public void sortCards(ArrayList<String> player) {

        // Loop through the player's deck.
        for (int i = 1; i < player.size(); i++) {

            // Created two temporary variables that hold the real card value from the 52 card deck of the player's deck.
            int tempIndexFirst = 0;
            int tempIndexTwo = 0;

            // Have temporary string to get the index 1 of the player's card. (Aka, current index going through from i).
            String tempOne = player.get(i);

            // Previous index of the current index.
            int tempTwo = i - 1;

            // Getting the real value of the player's cards from the 52-card deck.
            for (int m = 0; m < this.deck.length; m++) {
                if (player.get(i).equals(this.deck[m])) {
                    tempIndexFirst = m;
                    break;
                }
            }
            for (int l = 0; l < this.deck.length; l++) {
                if (player.get(tempTwo).equals(this.deck[l])) {
                    tempIndexTwo = l;
                    break;
                }
            }

            // Compares the indexes from the player's deck by using the real valules received from the 52 deck to see which one comes first.
            while (tempTwo >= 0 && tempIndexTwo > tempIndexFirst) {
                player.set(tempTwo + 1, player.get(tempTwo));
                tempTwo--;

                // Reset tempIndexTwo so that after 1 or more loops, when the previous cards are still larger than the "i" card. So we can keep 
                // comparing. But only compare when temptwo isn't negative. (Aka, out of bounds).
                if (!(tempTwo < 0)) {
                    for (int j = 0; j < this.deck.length; j++) {
                        if (player.get(tempTwo).equals(this.deck[j])) {
                            tempIndexTwo = j;
                            break;
                        }
                    }
                }
            }
            player.set(tempTwo + 1, tempOne);
        }
    }

    // Method: Printing cards.
    public void printCards(Player playerNeung, Player playerSom, Player playerSam, Player playerSi) {
        for (int i = 0; i < 13; i++) {
            System.out.println(playerNeung.getCardShuffled(i));
        }
        System.out.println("-------------");

        for (int i = 0; i < 13; i++) {
            System.out.println(playerSom.getCardShuffled(i));
        }
        System.out.println("-------------");

        for (int i = 0; i < 13; i++) {
            System.out.println(playerSam.getCardShuffled(i));
        }
        System.out.println("-------------");
        
        for (int i = 0; i < 13; i++) {
            System.out.println(playerSi.getCardShuffled(i));
        }
        System.out.println("-------------");
    }

    // Method: Find 3 of Spades.
    // public void findThreeOfSpades(ArrayList<String> playerOne, ArrayList<String> playerTwo, ArrayList<String> playerThree, ArrayList<String> playerFour, ArrayList<String> cardsPlayed, String[] deck) {

    //     // Going through all of the player's deck to find 3 of Spades, add that to the cardsPlayed then remove it from the player. 
    //     // Also updates the player's card deck if found 3 of Spades.
    //     if (playerOne.get(0).equals(deck[0])) {
    //         cardsPlayed.add("3 of Spades");
    //         playerOne.remove(0);
    //     } else if (playerTwo.get(0).equals(deck[0])) {
    //         cardsPlayed.add("3 of Spades");
    //         playerTwo.remove(0);
    //     } else if (playerThree.get(0).equals(deck[0])) {
    //         cardsPlayed.add("3 of Spades");
    //         playerThree.remove(0);
    //     } else if (playerFour.get(0).equals(deck[0])) {
    //         cardsPlayed.add("3 of Spades");
    //         playerFour.remove(0);
    //     }
    // }
}