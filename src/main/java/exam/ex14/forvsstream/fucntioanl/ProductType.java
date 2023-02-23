package exam.ex14.forvsstream.fucntioanl;

import java.util.Arrays;

public enum ProductType {

    DDA, CREDIT_CARD, HELOC;

    public static ProductType of(String type) {
        return Arrays.stream(ProductType.values())
                .filter(productType -> productType.name().equalsIgnoreCase(type))
                .findFirst()
                .orElse(null);
    }
}
