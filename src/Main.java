import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class Main {

    public static void main(String[] args) {
        System.out.println("hello world from java 17!");
        String first = "hello";
        String second = "good morning";

        BinaryOperator<String> concat = String::concat;
        UnaryOperator<String> makeUpperCase = String::toUpperCase;


        concat.andThen(makeUpperCase);
    }


}
