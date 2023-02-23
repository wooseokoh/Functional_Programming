package exam.ex14.forvsstream.before;

import java.util.*;

public enum ProductTypeWithMap {

    DDA, CREDIT_CARD, HELOC;

    private static final Map<String, ProductTypeWithMap> VALUE_MAP = new HashMap<>();
    static {
        Arrays.stream(ProductTypeWithMap.values()).toList()
                .forEach(productTypeWithMap -> VALUE_MAP.put(productTypeWithMap.name().toUpperCase(Locale.ROOT), productTypeWithMap));
    }
    public static Optional<ProductTypeWithMap> of(String type) {
        return Optional.ofNullable(VALUE_MAP.getOrDefault(type.toUpperCase(Locale.ROOT), null));
    }
}