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
    public String getDeckCard(int index) {
        return deck[index];
    }

    // Gets shuffled deck.
    public ArrayList<String> getDeckShuffled() {

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
        return this.deckShuffled;
    }
}