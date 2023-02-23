package exam.ex14.forvsstream.before;

import java.util.Optional;

public enum ProductType {

    DDA, CREDIT_CARD, HELOC;

    public static Optional<ProductType> of(String type) {
        for (ProductType productType : values()) {
            if (productType.name().equalsIgnoreCase(type)) {
                return Optional.of(productType);
            }
        }
        return Optional.empty();
    }
}