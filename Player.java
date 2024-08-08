import java.util.ArrayList; 

public class Player {
    private ArrayList<String> cardsInHand;
    private static Deck deck = new Deck();
    private static int playerIdCount;
    private int playerId;

    // Constructors.
    public Player() {
        this.cardsInHand = new ArrayList<>();
        playerIdCount++;
        this.playerId = 0;
    }

    // Getters.

    // Get cards in hand.
    public ArrayList<String> getCardsInHand() {
        return this.cardsInHand;
    }

    // Get players' id.
    public int getPlayerId() {
        return playerId;
    }

    // Methods.
    
    // Method: Add shuffled deck to cards in hand.
    public void addDeckShuffled(int i) {
        this.cardsInHand.add(deck.getDeckShuffled().get(i));
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
            for (int m = 0; m < deck.getDeckCard().length; m++) {
                if (this.cardsInHand.get(i).equals(deck.getDeckCard()[m])) {
                    tempIndexFirst = m;
                    break;
                }
            }
            for (int l = 0; l < deck.getDeckCard().length; l++) {
                if (this.cardsInHand.get(tempTwo).equals(deck.getDeckCard()[l])) {
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
                    for (int j = 0; j < deck.getDeckCard().length; j++) {
                        if (this.cardsInHand.get(tempTwo).equals(deck.getDeckCard()[j])) {
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
    public static void shuffleDeck() {
        deck.shuffleDeck();
    }

    // Method: Set playerId.
    public void setPlayerId() {
        this.playerId = playerIdCount;
    }

    // Method: Deal card.
    public void dealCard(String cardInHand) {

        int indexCardPlayed = 0;
        int indexCardInHand = 0;

        String cardPlayed = "";

        if (deck.getCardsPlayed().size() < 1) {
            cardPlayed = deck.getCardsPlayed().get(0);
        } else if (deck.getCardsPlayed().size() > 1) {
            cardPlayed = deck.getCardsPlayed().get(deck.getCardsPlayed().size() - 1);
        }

        for (int m = 0; m < deck.getDeckCard().length; m++) {
            if (cardPlayed.equals(deck.getDeckCard()[m])) {
                indexCardPlayed = m;
                break;
            }
        }

        for (int l = 0; l < deck.getDeckCard().length; l++) {
            if (cardInHand.equals(deck.getDeckCard()[l])) {
                indexCardInHand = l;
                break;
            }
        }

        if (indexCardInHand > indexCardPlayed) {
            deck.getCardsPlayed().set(0, cardInHand);
            this.getCardsInHand().remove(indexCardInHand);
        } else {
            System.out.println("Card in hand is smaller than card on table!");
        }
    }
}
