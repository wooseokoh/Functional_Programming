package exam.ex15.reusestream;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Stream;

@Slf4j
public class ReuseStream2 {

    public static void main(String[] args) {
        final List<String> collection = List.of("Ant", "cHick3n", "bIrd", "123?");

        final Stream<String> stream = collection.stream()
                .filter(StringUtils::isAlphanumeric);

        log.debug("Lowercased: {}", stream.map(String::toLowerCase).toList()); // toList로 인해 마무리된 stream

        log.debug("Uppercased: {}", stream.map(String::toUpperCase).toList());
    }
}