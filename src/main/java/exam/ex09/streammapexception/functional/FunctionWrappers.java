package exam.ex09.streammapexception.functional;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;


@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FunctionWrappers {

    public static <T, R> Function<T, R> wrap(Function<T, R> function, Function<T, R> expectedException) {
        return input -> {
            try {
                return function.apply(input);

            } catch (Exception e) {
                return expectedException.apply(input);
            }
        };
    }

    public static <T, R, E extends Exception> Function<T, R> wrap(Function<T, R> function, Class<E> expectedException,
                                                                  Function<T, R>  exceptionFunction) {
        return input -> {
            try {
                return function.apply(input);

            } catch (Exception e) {
                try {
                    expectedException.cast(e);
                    return exceptionFunction.apply(input);
                }catch (ClassCastException cce){
                    throw e;
                }
            }
        };
    }
}