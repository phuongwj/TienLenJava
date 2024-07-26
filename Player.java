import java.util.ArrayList;

public class Player {
    private ArrayList<String> cardsInHand;
    private Deck deck;

    // Constructors.
    public Player() {
        this.cardsInHand = new ArrayList<>();
        this.deck = new Deck();
    }

    public void addDeckShuffled() {
        this.cardsInHand.add(this.deck.getDeckShuffled(2));
    }

    // public ArrayList<String> getCardShuffled() {
    //     return this.cardsInHand;
    // }

    // public String toString(int i) {
    //     return this.cardsInHand.get(i);
    // }
}
