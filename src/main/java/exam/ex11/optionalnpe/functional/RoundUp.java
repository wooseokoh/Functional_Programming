package exam.ex11.optionalnpe.functional;

import exam.ex09.streammapexception.Result;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.Optional;

public class RoundUp {

    public Optional<BigDecimal> halfUp(Object input, int scale) {
        return Optional.ofNullable(input)
                .map(Object::toString)
                .map(String::trim)
                .map(string -> Result.attempt(() -> new BigDecimal(string)))
                .map(Result::getValue)
                .map(bigDecimal -> bigDecimal.setScale(scale, RoundingMode.HALF_UP));
    }
}