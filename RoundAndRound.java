import java.util.ArrayList;

public class RoundAndRound {

    public RoundAndRound() {
    }

    // Getters.

    // Methods.

    // Method: Rotate players' turns.
    public void rotateTurns(int indexThreeOfSpades, ArrayList<Player> players) {
        for (int i = 0; i < 4; i++) {
            if (indexThreeOfSpades == 0) {
                break;
            } else if (indexThreeOfSpades > i) {
                players.add(players.get(0));
                players.remove(players.get(0));
            }
        }
    }

    
}
