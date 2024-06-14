import java.sql.Array;
import java.util.ArrayList;

public class Source {
    public static void main(String[] args) {

        String[] suits = {"Spades", "Clubs", "Diamonds", "Hearts"};

        String[] numbers = {"3", "4", "5", "6", "7", "8", "9",
                            "10", "J", "Q", "K", "A", "2"};

        // - solution: after having the 52 cards shuffled, put 13 of them into 4 arrays.
        ArrayList<String> deckOfCards = shuffleCards(suits, numbers);
        int j = 51;
        for (int i = 0; i < 4; i++) {;
            int counter = 0;
            while (counter < 13) {
                System.out.println(deckOfCards.get(j));
                j--;
                counter++;
            }
            System.out.println("-------");
        }
    }

    public static ArrayList<String> shuffleCards(String[] suits, String[] numbers) {

        // Deck Of Cards creation.
        ArrayList<String> deckOfCards = new ArrayList<String>();
        for (int i= 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                String combined = numbers[j] + " of " + suits[i];
                deckOfCards.add(combined);
            }
        }

        // Shuffle deck of cards.
        for (int i = 0; i < 52; i++) {
            int n = i + ( (int) (Math.random() * (52 - i)) );

            String temp = deckOfCards.get(i);
            deckOfCards.set(i, deckOfCards.get(n) );
            deckOfCards.set(n, temp);
        }
        return deckOfCards;
    }
}
