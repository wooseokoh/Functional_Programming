package exam.ex07.consumerexception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.function.BiConsumer;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Calculations {

    public static final BiConsumer<Integer, Integer> DIVISION = (dividend, divisor) ->
            log.debug("# Divsion of {}/{} = {}", dividend, divisor, dividend / divisor);

    public static final BiConsumer<Integer, Integer> DIVISION_STOP = (dividend, divisor) -> {
        try {
            DIVISION.accept(dividend,divisor);
        }catch (Exception e){
            throw new RuntimeException("Cannot perform a division.", e);
        }
    };

    public static final BiConsumer<Integer, Integer> DIVISION_CONTINUED = (dividend, divisor) -> {
        try {
            DIVISION.accept(dividend,divisor);
        }catch (Exception e){
            log.error("Failed to divided {} by {}", dividend, divisor, e);
        }
    };
}
