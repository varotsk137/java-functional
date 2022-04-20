package functionalInterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        System.out.println("== No Supplier ==");
        System.out.println(getDbConnectionUrl());
        System.out.println();

        System.out.println("== With Supplier ==");
        System.out.println(getDbConnectionUrlSupplier.get());
        getDbListSupplier.get().forEach(System.out::println);
        System.out.println();
    }

    static String getDbConnectionUrl() {
        return "jdbc://localhost:3331/users";
    }

    // Supplier return any data that you want //
    static Supplier<String> getDbConnectionUrlSupplier = () -> "jdbc://localhost:3331/users";
    static Supplier<List<String>> getDbListSupplier = () -> List.of("MariaDB", "MySQL", "Oracle", "MongoDB");
}
