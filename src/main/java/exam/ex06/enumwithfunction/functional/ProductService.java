package exam.ex06.enumwithfunction.functional;

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
        return salesType.calculatePrice(this, product);
    }

    BigDecimal getRegularPrice(Product product) {
        return priceCalculator.getRegularPriceFor(product);
    }

    BigDecimal getPromoPrice(Product product) {
        return priceCalculator.getPromoPriceFor(product);
    }


}
