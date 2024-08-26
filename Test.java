import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        String something = "3 of Spades, 4 of Spades, 5 of Diamonds";
        String[] haha = something.split(", ");
        
        System.out.println(something.split(", ")[2]);
        System.out.println(Arrays.toString(haha));
    }
}
