package exam.ex09.streammapexception.functional;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class Calculator {

    public static void main(String[] args) {
        final List<String> numbers = List.of("-1", "Zero", "1");

        numbers.stream()
                .map(FunctionWrappers.wrap(Calculator::toBigDecimal, toNull()))
                .filter(Objects::nonNull)
                .collect(Collectors.toList())
                .forEach(number -> log.debug("Transformed {} to BigDecimal.", number));
    }

    static BigDecimal toBigDecimal(String number) {
        return new BigDecimal(number);
    }

    static Function<String, BigDecimal> toNull() {
        return input -> {
            log.debug("Cannot transform '{}' to BigDecimal. so null returns", input);
            return null;
        };
    }
}