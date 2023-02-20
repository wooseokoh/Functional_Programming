package exam.ex08.predicateexception.flaw;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
public class CalculatorHappyPath {
    public static void main(String[] args) {

        final List<Integer> numbers = List.of(-1, 0, 1, 2, 3, 4, 5);

        numbers.stream()
                .filter(Objects::nonNull)
                .filter(CalculatorTryCatch::isPrime)
                .collect(Collectors.toList())
                .forEach(number -> log.debug("{} is a prime number.", number));
    }

    static boolean isPrime(Integer number) {
        return BigInteger.valueOf(number.longValue()).isProbablePrime(100);
    }
}
