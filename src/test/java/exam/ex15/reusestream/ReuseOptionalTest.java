package exam.ex15.reusestream;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

@Slf4j
public class ReuseOptionalTest {

    public static void main(String[] args) {
        final Optional<String[]> strings = Optional.of("a,B,c,1,D").map(value -> value.split(","));

//        final Stream<String[]> stream = strings.stream(); // toList로 인해 마무리된 stream

        log.debug("Lowercased: {}", strings.stream().flatMap(Arrays::stream)
                .filter(StringUtils::isAllLowerCase).toList());

        log.debug("Uppercased: {}", strings.stream().flatMap(Arrays::stream)
                .filter(StringUtils::isAllUpperCase).toList());

    }
}
