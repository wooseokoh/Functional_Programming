package exam.ex09.streammapexception.flaw;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class CalculatorTryCatch {
    public static void main(String[] args) {

        final List<String> numbers = List.of("-1", "Zero", "1");

        try {
            numbers.stream()
                    .map(CalculatorTryCatch::toBigDecimal)
                    .collect(Collectors.toList())
                    .forEach(number -> log.debug("Transformed {} to BigDecimal.", number));
        }catch (Exception e){
            throw new RuntimeException("Failed to transform into BigDecimal.", e);
        }
    }

    static BigDecimal toBigDecimal(String number) {
        return new BigDecimal(number);
    }
}
