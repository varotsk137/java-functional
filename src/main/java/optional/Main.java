package optional;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        String nullMsg = null;
        String message = "Hello";
        Object value = Optional.ofNullable(message).orElseGet(() -> "default value");

        System.out.println(value);

        Object value2 = Optional.ofNullable(message).orElseThrow(() -> new IllegalStateException("value is null"));

        System.out.println(value2);

        Optional.ofNullable(nullMsg).ifPresentOrElse(System.out::println, () -> System.out.println("NULL VALUE IS PASSED"));

    }
}
