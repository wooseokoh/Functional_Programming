package exam.ex14.forvsstream.before;

import java.util.Optional;

public enum ProductTypeWithValueOf {

    DDA, CREDIT_CARD, HELOC;

    public static Optional<ProductTypeWithValueOf> of(String type) {
        try {
            return Optional.of(valueOf(type.toUpperCase()));
        }catch (NullPointerException | IllegalArgumentException e){
            return Optional.empty();
        }
    }
}