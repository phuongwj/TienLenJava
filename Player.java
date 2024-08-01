import java.util.ArrayList;

public class Player {
    private ArrayList<String> cardsInHand;
    private Deck deck;

    // Constructors.
    public Player() {
        this.cardsInHand = new ArrayList<>();
        this.deck = new Deck();
        this.deck.shuffleDeck();
    }

    // Getters.

    // Get cards in hand.
    public ArrayList<String> getCardsInHand() {
        return this.cardsInHand;
    }

    // Methods.
    
    // Add shuffled deck to cards in hand.
    public void addDeckShuffled(int i) {
        this.cardsInHand.add(this.deck.getDeckShuffled().get(i));
    }

    
}
