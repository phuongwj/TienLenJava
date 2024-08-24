import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        String something = "azmotherfuckermotherfuckermotherfucker";
        String[] haha = something.split("m", 4);
        
        System.out.println(Arrays.toString(haha));
    }
}
