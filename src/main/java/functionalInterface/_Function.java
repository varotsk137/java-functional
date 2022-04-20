package functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        // Function Example >> Take 1 argument and produces 1 result //
        System.out.println("== Function ==");
        int increment = incrementByOne(1);
        System.out.println(increment);

        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        int multiply = multiplyByTenFunction.apply(increment2);
        System.out.println(multiply);

        Function<Integer, Integer> addByOneThenMultiplyByTen
                = incrementByOneFunction.andThen(multiplyByTenFunction);
        Integer multiply2 = addByOneThenMultiplyByTen.apply(5);
        System.out.println(multiply2);
        System.out.println();

        // BiFunction Example >> Take 2 arguments and produces 1 result //
        System.out.println("== Bi-Function ==");
        System.out.println("normal: "+incrementByOneAneMultiply(4, 100));
        System.out.println("bi-function: "+incrementByOneAndMultiplyBiFunction.apply(4,100));

    }

    // Function that receive one input and return one output
    static int incrementByOne(int number) {
        return number + 1;
    }

    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;
    static Function<Integer, Integer> multiplyByTenFunction = number -> number * 10;

    // Bi-Function
    static int incrementByOneAneMultiply(int number, int numToMultiplyBy) {
        return (number + 1) * numToMultiplyBy;
    }

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction
            = (numberToIncrementByOne, numberToMultiplyBy) -> (numberToIncrementByOne + 1) * numberToMultiplyBy;

}
