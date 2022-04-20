package conbinationPattern;

import java.time.LocalDate;

import static conbinationPattern.CustomerRegistrationValidator.*;
import static conbinationPattern.CustomerRegistrationValidator.ValidationResult.SUCCESS;

public class Main {
    public static void main(String[] args) {
        Customer customer =
                new Customer("Alice", "alice@mail.com", "0828133122", LocalDate.of(2000,1,1));
        Customer inValidCustomer =
                new Customer("Alice", "alice@mail.com", "0828111111", LocalDate.of(2020,1,1));

        System.out.println(new CustomerValidatorService().isCustomerValid(customer));
        // We know that customer is invalid but don't know which part is invalid
        System.out.println(new CustomerValidatorService().isCustomerValid(inValidCustomer));

        System.out.println("");
        System.out.println("- Combinator Pattern -");
        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult())
                .apply(customer);

        System.out.println(result);

        if ( result != SUCCESS ) {
            throw new IllegalStateException(result.name());
        }
    }
}
