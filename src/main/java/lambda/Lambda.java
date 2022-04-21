package lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambda {
    public static void main(String[] args) {

        Function<String, String> nameToUpperCase = name -> {
            if (name.isBlank()) throw new IllegalArgumentException("Name is blank");
            return name.toUpperCase();
        };

        BiFunction<String, Integer, String> nameToUpperCase2 = (name, age) -> {
            if (name.isBlank()) throw new IllegalArgumentException("Name is blank");
            System.out.println(age);
            return name.toUpperCase();
        };

        System.out.println(nameToUpperCase2.apply("alex", 20));


    }
}
