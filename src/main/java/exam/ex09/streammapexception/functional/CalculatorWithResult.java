package exam.ex09.streammapexception.functional;

import exam.ex09.streammapexception.Result;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class CalculatorWithResult {

    public static void main(String[] args) {
        final List<String> numbers = List.of("-1", "Zero", "1");

        numbers.stream()
                .map(numberString -> Result.attempt(() -> CalculatorWithResult.toBigDecimal(numberString)))
                .filter(Result::isSuccess)
                .collect(Collectors.toList())
                .forEach(result -> log.debug("Transformed {} to BigDecimal.", result.getValue()));
    }

    static BigDecimal toBigDecimal(String number) {
        return new BigDecimal(number);
    }
}