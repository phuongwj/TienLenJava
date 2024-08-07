import java.util.ArrayList;

public class Player {
    private ArrayList<String> cardsInHand;
    private static Deck deck = new Deck();

    // Constructors.
    public Player() {
        this.cardsInHand = new ArrayList<>();
    }

    // Getters.

    // Get cards in hand.
    public ArrayList<String> getCardsInHand() {
        return this.cardsInHand;
    }

    // Methods.
    
    // Method: Add shuffled deck to cards in hand.
    public void addDeckShuffled(int i) {
        this.cardsInHand.add(this.deck.getDeckShuffled().get(i));
    }

    // Method: Sorting the cards low to high in Players' hand using Insertion Sort.
    public void sortCards() {

        // Loop through the Player's deck.
        for (int i = 1; i < this.cardsInHand.size(); i++) {

            // Created two temporary variables that hold the real card value from the 52 card deck of the Player's deck.
            int tempIndexFirst = 0;
            int tempIndexTwo = 0;

            // Have temporary string to get the index 1 of the Player's card. (Aka, current index going through from i).
            String tempOne = this.cardsInHand.get(i);

            // Previous index of the current index.
            int tempTwo = i - 1;

            // Getting the real value of the Player's cards from the 52-card deck.
            for (int m = 0; m < this.deck.getDeckCard().length; m++) {
                if (this.cardsInHand.get(i).equals(this.deck.getDeckCard()[m])) {
                    tempIndexFirst = m;
                    break;
                }
            }
            for (int l = 0; l < this.deck.getDeckCard().length; l++) {
                if (this.cardsInHand.get(tempTwo).equals(this.deck.getDeckCard()[l])) {
                    tempIndexTwo = l;
                    break;
                }
            }

            // Compares the indexes from the Player's deck by using the real values received from the 52 deck to see which one comes first.
            while (tempTwo >= 0 && tempIndexTwo > tempIndexFirst) {
                this.cardsInHand.set(tempTwo + 1, this.cardsInHand.get(tempTwo));
                tempTwo--;

                // Reset tempIndexTwo so that after 1 or more loops, when the previous cards are still larger than the "i" card. So we can keep 
                // comparing. But only compare when tempTwo isn't negative. (Aka, out of bounds).
                if (!(tempTwo < 0)) {
                    for (int j = 0; j < this.deck.getDeckCard().length; j++) {
                        if (this.cardsInHand.get(tempTwo).equals(this.deck.getDeckCard()[j])) {
                            tempIndexTwo = j;
                            break;
                        }
                    }
                }
            }
            this.cardsInHand.set(tempTwo + 1, tempOne);
        }
    }

    // Method: Call shuffle deck.
    public static void callShuffleDeck() {
        deck.shuffleDeck();
        System.out.println(deck.getDeckShuffled());
    }
}
