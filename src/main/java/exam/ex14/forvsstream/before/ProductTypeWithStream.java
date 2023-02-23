package exam.ex14.forvsstream.before;

import java.util.Arrays;
import java.util.Optional;

public enum ProductTypeWithStream {

    DDA, CREDIT_CARD, HELOC;

    public static Optional<ProductTypeWithStream> of(String type) {
        return Arrays.stream(values())
                .filter(value -> value.name().equalsIgnoreCase(type))
                .findFirst();
    }
}