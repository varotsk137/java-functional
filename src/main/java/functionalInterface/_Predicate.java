package functionalInterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {

        String phoneNumber1 = "0830000000";
        String phoneNumber2 = "0911110174";
        String phoneNumber3 = "0929aaa74";

        System.out.println("== Without Predicate ==");
        System.out.println("== Is phone number valid ==");
        System.out.println(phoneNumber1+": "+isPhoneNumberValid(phoneNumber1));
        System.out.println(phoneNumber2+": "+isPhoneNumberValid(phoneNumber2));
        System.out.println(phoneNumber3+": "+isPhoneNumberValid(phoneNumber3));
        System.out.println();

        System.out.println("== Predicate ==");
        System.out.println("== Is phone number valid ==");
        System.out.println(phoneNumber1+": "+isPhoneNumberValidPredicate.test(phoneNumber1));
        System.out.println(phoneNumber2+": "+isPhoneNumberValidPredicate.test(phoneNumber2));
        System.out.println(phoneNumber3+": "+isPhoneNumberValidPredicate.test(phoneNumber3));
        System.out.println();

        System.out.println("== Chain Predicate ==");
        System.out.println("== Is phone number valid and contain number 3 ==");
        System.out.println(phoneNumber1+": "+isPhoneNumberValidPredicate.and(isPhoneNumberContainsNumber3).test(phoneNumber1));
        System.out.println(phoneNumber2+": "+isPhoneNumberValidPredicate.and(isPhoneNumberContainsNumber3).test(phoneNumber2));
        System.out.println(phoneNumber3+": "+isPhoneNumberValidPredicate.and(isPhoneNumberContainsNumber3).test(phoneNumber3));

        System.out.println("== Bi Predicate ==");
        System.out.println("== Is phone number contains input number ==");
        System.out.println(phoneNumber1+": "+isPhoneNumberContainsInputValue.test(phoneNumber1, "4"));
        System.out.println(phoneNumber2+": "+isPhoneNumberContainsInputValue.test(phoneNumber2, "4"));
        System.out.println(phoneNumber3+": "+isPhoneNumberContainsInputValue.test(phoneNumber3, "4"));

    }

    static boolean isPhoneNumberValid(String phoneNumber) {
        return (phoneNumber.startsWith("09") || phoneNumber.startsWith("08")) && phoneNumber.length() == 10;
    }

    static Predicate<String> isPhoneNumberValidPredicate =
            phoneNumber -> (phoneNumber.startsWith("09") || phoneNumber.startsWith("08")) && phoneNumber.length() == 10;

    static Predicate<String> isPhoneNumberContainsNumber3 =
            phoneNumber -> phoneNumber.contains("3");

    static BiPredicate<String, String> isPhoneNumberContainsInputValue =
            (phoneNumber, input) -> phoneNumber.contains(input);
}
