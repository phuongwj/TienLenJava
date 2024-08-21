import java.util.ArrayList;

public class RoundAndRound {

    public RoundAndRound() {
    }

    // Getters.

    // Methods.

    // Method: Rotate players' turns according to the chosen player.
    // Used for finding 3 of Spades and when 3 players decide to Pass their turn.
    public void rotateTurns(int chosenIndex, ArrayList<Player> players) {
        for (int i = 0; i < players.size(); i++) {
            if (chosenIndex == 0) {
                break;
            } else if (chosenIndex > i) {
                players.add(players.get(0));
                players.remove(players.get(0));
            }
        }
    }

    
}
