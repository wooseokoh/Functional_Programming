package exam.ex06.enumwithfunction.functional;

import exam.ex06.enumwithfunction.Product;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.function.BiFunction;

@RequiredArgsConstructor
public enum SalesType {

    REGULAR((productService, product) -> productService.getRegularPrice(product)),
    PROMOTION(ProductService::getPromoPrice);

    private final BiFunction<ProductService, Product, BigDecimal> calculatePrice;


    public BigDecimal calculatePrice(ProductService productService, Product product) {
        return  this.calculatePrice.apply(productService, product);
    }
}