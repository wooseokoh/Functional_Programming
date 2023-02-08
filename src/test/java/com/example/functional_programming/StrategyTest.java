package com.example.functional_programming;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import java.math.BigDecimal;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import com.example.functional_programming.entity.PurchaseItem;

public class StrategyTest {

    public static Stream<Arguments> dataFactory() {
        List<PurchaseItem> purchaseItemList = List.of(
                new PurchaseItem("cookie",  BigDecimal.valueOf(1500)),
                new PurchaseItem("serial", BigDecimal.valueOf(2500)),
                new PurchaseItem("hambuger",  BigDecimal.valueOf(1530)),
                new PurchaseItem("milk",  BigDecimal.valueOf(1200)),
                new PurchaseItem("bread",  BigDecimal.valueOf(4500)),
                new PurchaseItem("bread",  BigDecimal.valueOf(4500)),
                new PurchaseItem("cookie",  BigDecimal.valueOf(1500)),
                new PurchaseItem("bread",  BigDecimal.valueOf(4500)),
                new PurchaseItem("bread",  BigDecimal.valueOf(4500)),
                new PurchaseItem("milk",  BigDecimal.valueOf(1200))
        );

        return Stream.of(
                arguments(purchaseItemList, BigDecimal.valueOf(3000), "cookie", BigDecimal.valueOf(27430)),
                arguments(purchaseItemList, BigDecimal.valueOf(18000), "bread", BigDecimal.valueOf(27430))
                );
    }

    @ParameterizedTest
    @MethodSource("dataFactory")
    public void 구매내역_총지불금액_구하기(List<PurchaseItem> purchaseItemList, BigDecimal expected, String item, BigDecimal expectedTotal) {
        BigDecimal total = purchaseItemList.stream().map(p -> p.getValue())
                .reduce(BigDecimal.ZERO, BigDecimal::add) ;
        assertEquals(expectedTotal, total);
    }

    @ParameterizedTest
    @MethodSource("dataFactory")
    public void 아이템별로_구매내역_총지불금액_구하기_필터전략추가(List<PurchaseItem> purchaseItemList, BigDecimal expectedTotal, String item) {
        BigDecimal total = purchaseItemList.stream()
                .filter(p -> p.getItem().equals(item))
                .map(PurchaseItem::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        assertEquals(expectedTotal, total);
    }

    @ParameterizedTest
    @MethodSource("dataFactory")
    public void 위_로직을_메서드로_리팩터링하고_필터부분을_파라미터로_받기(List<PurchaseItem> purchaseItemList, BigDecimal expectedTotal, String item) {

        Predicate<PurchaseItem> itemSelector = p -> p.getItem().equals(item);
        BigDecimal total = totalCalcuratorByItem(purchaseItemList, itemSelector);
        assertEquals(expectedTotal, total);
    }

    private BigDecimal totalCalcuratorByItem(List<PurchaseItem> list, Predicate<PurchaseItem> selector) {
        return list.stream()
                .filter(selector)
                .map(PurchaseItem::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
