package exam.ex15.reusestream;

import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.List;

import static exam.ex15.reusestream.StreamUtils3.alphabetsOnlyAndMap;

@Slf4j
public class ReuseStream3 {

    public static void main(String[] args) {
        final Collection<String> collection = List.of("Ant", "cHick3n", "bIrd", "123?");

        log.debug("Uppercased: {}", alphabetsOnlyAndMap(collection, String::toUpperCase).toList());

        log.debug("Lowercased: {}", alphabetsOnlyAndMap(collection, String::toLowerCase).toList());
    }
}