package exam.ex07.consumerexception.functional;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LambdaWrappers {

    public static <T, V> BiConsumer<T, V> wrapThrwosException(BiConsumer<T, V> consumer) {
        return (T t, V v) -> {
            try {
                consumer.accept(t, v);
            } catch (Exception e) {
                log.error("Failed to execute the job and throws and exception", e);
                throw new RuntimeException("Cannot perform a division.", e);
            }
        };
    }

    public static <T, V> BiConsumer<T, V> wrapContinue(BiConsumer<T, V> consumer) {
        return (T t, V v) -> {
            try {
                consumer.accept(t, v);
            } catch (Exception e) {
                log.error("Failed to execute the job but continue", e);
            }
        };
    }

    public static <T, V, E extends Exception> BiConsumer<T, V> wrapContinueSelectively(BiConsumer<T, V> consumer, Class<E> ignoredException) {
        return (number, arg) -> {
            try {
                consumer.accept(number, arg);

            } catch (Exception e) {
                try {
                    ignoredException.cast(e);
                    System.out.println("{} was caughit, but it's continued ... " + ignoredException.cast(e).getClass().getSimpleName());

                } catch (ClassCastException cce) {
                    throw new RuntimeException("Expected exception to ignore is not caught", e);
                }
            }
        };
    }

    public static <T, V, E extends Exception> BiConsumer<T, V> wrapContinueSelectively(BiConsumer<T, V> consumer, Class<E> ignoredException,
                                                                                       Consumer<Throwable> exceptionConsumer) {
        return (number, arg) -> {
            try {
                consumer.accept(number, arg);

            } catch (Exception e) {
                try {
                    ignoredException.cast(e);
                    System.out.println("{} was caughit, but it's continued ... " + ignoredException.cast(e).getClass().getSimpleName());
                    exceptionConsumer.accept(e);
                } catch (ClassCastException cce) {
                    throw new RuntimeException("Expected exception to ignore is not caught", e);
                }
            }
        };
    }
}
