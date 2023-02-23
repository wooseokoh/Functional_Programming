package exam.ex14.forvsstream.before;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Optional;

public enum ProductTypeWithEnumSet {

    DDA, CREDIT_CARD, HELOC;

    public static Optional<ProductTypeWithEnumSet> of(String type) {
        return EnumSet.allOf(ProductTypeWithEnumSet.class).stream()
                .filter(value -> value.name().equalsIgnoreCase(type))
                .findFirst();
    }
}