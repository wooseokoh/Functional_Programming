package exam.ex09.streammapexception.flaw;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class CalculatorHappyPath {
    public static void main(String[] args) {

        final List<String> numbers = List.of("-1", "0", "1");

        numbers.stream()
                .map(CalculatorHappyPath::isPrime)
                .collect(Collectors.toList())
                .forEach(number -> log.debug("Transformed {} to BigDecimal.", number));
    }

    static BigDecimal isPrime(String number) {
        return new BigDecimal(number);
    }
}
