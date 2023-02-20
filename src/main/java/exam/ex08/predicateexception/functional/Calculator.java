package exam.ex08.predicateexception.functional;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
public class Calculator {

    public static void main(String[] args) {
        final List<Integer> numbers = List.of(-1, 0, 1, 2, 3, 4, 5);
        
        numbers.stream()
                .filter(Objects::nonNull)
                .filter(
                        PredicateWrappers.wrap(Calculator::isPrime, IllegalArgumentException.class, ignoreException()))
                .collect(Collectors.toList())
                .forEach(number -> System.out.println(number + " is a prime number."));
    }

    static boolean isPrime(Integer number) {
        if (number < 1) {
            throw new IllegalArgumentException("The input number " + number + " is not a positive integer.");
        }
        return BigInteger.valueOf(number.longValue()).isProbablePrime(100);
    }

    private static Predicate<Exception> ignoreException(){
        return ex -> {
            log.debug("Ignoring {}: {}", ex.getClass().getSimpleName(), ex.getMessage());
            return false;
        };
    }
}