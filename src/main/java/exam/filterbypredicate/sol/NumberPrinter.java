package exam.filterbypredicate.sol;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static exam.filterbypredicate.sol.NumberPredicates.EVEN_VALUES;
import static exam.filterbypredicate.sol.NumberPredicates.ODD_VALUES;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NumberPrinter {
    public static void main(String[] args) {
        final List<Integer> numbers = IntStream.range(1, 100)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Odd numbers :" + NumberFunctions.FILTER_BY_PREDICATE.apply(numbers, ODD_VALUES));
        System.out.println("Odd numbers :" + NumberFunctions.FILTER_BY_PREDICATE.apply(numbers, EVEN_VALUES));
    }
}
