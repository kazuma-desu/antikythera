package sa.com.cloudsolutions.antikythera.evaluator;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Functional {

    private void printHello(Function<String, String> f)
    {
        System.out.println(f.apply("Ashfaloth"));
    }

    private void printHello(BiFunction<String, String, String> f)
    {
        System.out.println(f.apply("Thorin", "Oakenshield"));
    }

    private void greet1() {
        printHello( a -> "Hello " + a );
    }

    private void greet2() {
        printHello( a -> { return "Hello " + a; });
    }

    private void greet3() {
        printHello( (a,b) -> "Hello " + a + " " + b);
    }

    private void sorting1() {
        List<Integer> numbers = new ArrayList<>(List.of(8,9,0,3,1,4,5,6,7,2));
        Collections.sort(numbers);
        numbers.forEach(System.out::print);
        System.out.println();
    }

    private void sorting2() {
        List<Integer> numbers = new ArrayList<>(List.of(8,9,0,3,1,4,5,6,7,2));
        Collections.sort(numbers, (a,b) -> b - a);
        numbers.forEach(System.out::print);
        System.out.println();
    }

    public static void main(String[] args) {
        Functional f = new Functional();
        f.greet1();
        f.greet2();
        f.greet3();
        f.sorting1();
        f.sorting2();
    }

}
