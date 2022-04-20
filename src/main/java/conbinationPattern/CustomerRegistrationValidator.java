package conbinationPattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static conbinationPattern.CustomerRegistrationValidator.*;
import static conbinationPattern.CustomerRegistrationValidator.ValidationResult.*;

public interface CustomerRegistrationValidator extends Function<Customer, ValidationResult> {

    default CustomerRegistrationValidator and(CustomerRegistrationValidator other) {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(SUCCESS) ? other.apply(customer) : result;
        };
    }

    static CustomerRegistrationValidator isEmailValid() {
        return customer -> customer.getEmail().contains("@") ? SUCCESS : EMAIL_INVALID;
    }

    static CustomerRegistrationValidator isPhoneNumberValid() {
        return customer -> customer.getPhoneNumber().startsWith("0") && customer.getPhoneNumber().length() == 10 ? SUCCESS : PHONE_NUMBER_INVALID;
    }

    static CustomerRegistrationValidator isAdult() {
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 16 ? SUCCESS : IS_NOT_AN_ADULT;
    }

    enum ValidationResult {
        SUCCESS,
        PHONE_NUMBER_INVALID,
        EMAIL_INVALID,
        IS_NOT_AN_ADULT
    }
}
