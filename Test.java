// import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        // String something = "3 of Spades, 4 of Spades, 5 of Diamonds";
        // String[] haha = something.split(", ");
        
        // System.out.println(something.split(", ")[2]);
        // System.out.println(Arrays.toString(haha));
        String[] hehe = {"a", "b", "c", "d"};

        int counter = 0;
        for (int i = 0; i < hehe.length; i++) {
            System.out.println(hehe[i]);
            counter++;
            if (counter == 4) {
                System.out.println();
                if (i == 3) {
                    System.out.println("Turned i into 0");
                    i = 0;
                }
            }
        }
    }
}
