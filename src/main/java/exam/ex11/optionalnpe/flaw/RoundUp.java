package exam.ex11.optionalnpe.flaw;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

@Slf4j
public class RoundUp {

    public Object halfUp(Object input, int sacle) {
        final String stringValue = Objects.toString(input, "");
        if (stringValue.isBlank()) {
            return null;
        }
        try {
            final BigDecimal number = new BigDecimal(stringValue);
            return number.setScale(sacle, RoundingMode.HALF_UP);
        }catch (Exception e){
            log.warn("Failed to transform '{}' to BigDecimal.", stringValue, e);
        }
        return input;
    }
}