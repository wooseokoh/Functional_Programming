package exam.filterbypredicate.sol;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.Predicate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NumberPredicates {
    public static final Predicate<Integer> ODD_VALUES = number -> number % 2 != 0;
    public static final Predicate<Integer> EVEN_VALUES = number -> number % 2 != 0;
}
