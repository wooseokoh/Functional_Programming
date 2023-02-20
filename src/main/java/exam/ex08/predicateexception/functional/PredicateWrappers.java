package exam.ex08.predicateexception.functional;

import java.util.function.Predicate;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PredicateWrappers {

    public static <T, E extends Exception> Predicate<T> wrap(Predicate<T> predicate, Class<E> ignored, Predicate<Exception> exceptionPredicate) {
        return in -> {
            try {
                return predicate.test(in);

            } catch (Exception e) {
                try {
                    final E castedException = ignored.cast(e);
                    //handle the ignored exception

                    return exceptionPredicate.test(castedException);

                } catch (ClassCastException cce) {
                    //handle it, or throw it as-is/transformed
                    throw e;
                }
            }
        };
    }
}
