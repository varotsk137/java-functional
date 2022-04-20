package functionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {

        System.out.println("== Consumer ==");
        Customer maria = new Customer("Maria", "999999");
        greetCustomer(maria);
        greetCustomerConsumer.accept(maria);

        System.out.println("== BiConsumer ==");
        greetCustomer(maria, false);
        greetCustomerBiConsumer.accept(maria, false);
    }

    // Functional
    static Consumer<Customer> greetCustomerConsumer = customer ->
        System.out.println("Hello "+ customer.customerName +", thanks for registering phone number "+ customer.customerPhoneNumber);

    static BiConsumer<Customer, Boolean> greetCustomerBiConsumer = (customer, showPhoneNumber) ->
        System.out.println("Hello "+ customer.customerName +", thanks for registering phone number "+ (showPhoneNumber ? customer.customerPhoneNumber:"*********"));

    // Imperative
    static void greetCustomer(Customer customer) {
        System.out.println("Hello "+ customer.customerName +", thanks for registering phone number "+ customer.customerPhoneNumber);
    }

    static void greetCustomer(Customer customer, boolean showPhoneNumber) {
        System.out.println("Hello "+ customer.customerName +", thanks for registering phone number "+ (showPhoneNumber ? customer.customerPhoneNumber:"*********"));
    }

    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
