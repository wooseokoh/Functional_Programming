package exam.filterbypredicate.sol;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NumberFunctions {
    public static final BiFunction<List<Integer>, Predicate<Integer>, List<Integer>> FILTER_BY_PREDICATE
            = (input, predicate ) -> input.stream()
            .filter(Objects::nonNull)
            .filter(predicate)
            .collect(Collectors.toList());

}
