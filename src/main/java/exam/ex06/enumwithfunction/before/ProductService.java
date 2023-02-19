package exam.ex06.enumwithfunction.before;

import exam.ex06.enumwithfunction.PriceCalculator;
import exam.ex06.enumwithfunction.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class ProductService {
    private final PriceCalculator priceCalculator;

    public BigDecimal getPrice(SalesType salesType, Product product) {
        if (salesType == SalesType.REGULAR) {
            return priceCalculator.getRegularPriceFor(product);
        }
        if (salesType == SalesType.PROMOTION) {
            return priceCalculator.getPromoPriceFor(product);
        }
        throw new UnsupportedOperationException(String.format("Sales type [%s] is not supported.", salesType.name()));
    }
}
