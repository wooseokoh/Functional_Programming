package exam.ex15.reusestream;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class StreamUtils3 {

    public static Stream<String> alphabetsOnlyAndMap(Collection<String> collection, UnaryOperator<String> unaryOperator) {
        return collection.stream()
                .filter(StringUtils::isAlphanumeric)
                .map(unaryOperator);
    }
}