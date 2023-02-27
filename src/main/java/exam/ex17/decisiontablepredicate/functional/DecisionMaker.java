package exam.ex17.decisiontablepredicate.functional;

import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;

public interface DecisionMaker<T, R> {

    Map<Predicate<T>, R> getDecisions();

    Supplier<R> defaultDecision();

    default R getDecsision(T input){
        return getDecisions().entrySet().stream()
                .filter(entry -> entry.getKey().test(input))
                .findFirst()
                .map(Map.Entry::getValue)
                .orElseGet(defaultDecision());
    }
}
