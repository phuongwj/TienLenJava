import java.util.ArrayList;

public class Player {
    private ArrayList<String> cardsInHand;
    private Deck deck;

    // Constructors.
    public Player() {
        this.cardsInHand = new ArrayList<>();
        this.deck = new Deck();
    }

    public void addCardShuffled(int i) {
        this.cardsInHand.add(this.deck.getDeckCard(i));
    }

    public ArrayList<String> getCardShuffled() {
        return this.cardsInHand;
    }

    public String toString(int i) {
        return this.cardsInHand.get(i);
    }
}
