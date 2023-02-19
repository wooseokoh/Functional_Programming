package exam.ex06.enumwithfunction;

import java.math.BigDecimal;

public interface PriceCalculator {
    BigDecimal getRegularPriceFor(Product product);

    BigDecimal getPromoPriceFor(Product product);
}
