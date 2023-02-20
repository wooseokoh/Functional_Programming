package exam.ex08.predicateexception.flaw;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
public class CalculatorTryCatch {

    public static void main(String[] args) {
        final List<Integer> numbers = List.of(-1, 0, 1, 2, 3, 4, 5);

        try {
            numbers.stream()
                    .filter(Objects::nonNull)
                    .filter(CalculatorTryCatch::isPrime)
                    .collect(Collectors.toList())
                    .forEach(number -> log.debug("{} is a prime number.", number));

        } catch (IllegalArgumentException e) {
            log.error("Failed to collect prime numbers.", e);
        }
    }

    static boolean isPrime(Integer number) {
        if (number < 1) {
            throw new IllegalArgumentException(number + " is not a positive integer.");
        }
        return BigInteger.valueOf(number.longValue()).isProbablePrime(100);
    }
}