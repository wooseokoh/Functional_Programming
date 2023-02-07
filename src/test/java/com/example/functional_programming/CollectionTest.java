package com.example.functional_programming;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("collection stream")
public class CollectionTest {

    private static Stream<Arguments> dataListFactory() {
        return Stream.of(arguments(List.of("cat", "dog", "cow", "tiger", "lion"),
                List.of("CAT", "DOG", "COW", "TIGER", "LION"), "대문자로 바꾸기"));
    }

    @ParameterizedTest(name = "{2}")
    @MethodSource("dataListFactory")
    public void collection_iterator_basic(List<String> source, List<String> expected, String testTitle) {
        List<String> upperNames = new ArrayList<>();
        for (String name : source) {
            upperNames.add(name.toUpperCase());
        }
        assertEquals(expected, upperNames);
    }

    @ParameterizedTest(name = "{2}")
    @MethodSource("dataListFactory")
    public void collection_foreach(List<String> source, List<String> expected,
                                        String testTitle) {
        List<String> upperNames = new ArrayList<>();
        source.forEach(name -> upperNames.add(name.toUpperCase()));
        assertEquals(expected, upperNames);
    }

    @ParameterizedTest(name = "{2}")
    @MethodSource("dataListFactory")
    public void collection_stream(List<String> source, List<String> expected, String testTitle) {
        List<String> upperNames = source.stream().map(name -> name.toUpperCase())
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        assertEquals(expected, upperNames);
    }

    private static Stream<Arguments> filterDataFactory() {
        return Stream.of(
                arguments(List.of("cat", "dog", "cow", "tiger", "lion"),
                        List.of("dog", "cow", "lion"), "o"),
                arguments(List.of("cat", "dog", "cow", "tiger", "lion"),
                        List.of("cat", "cow"), "c"),
                arguments(List.of("cat", "dog", "cow", "tiger", "lion"),
                        List.of("tiger", "lion"), "i"));
    }

    @ParameterizedTest(name = "{2}")
    @MethodSource("filterDataFactory")
    public void filter(List<String> source, List<String> expected, String filterString) {
        List<String> filterNames = source.stream().filter(name -> name.contains(filterString))
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        assertEquals(expected, filterNames);
    }

    private static Stream<Arguments> reduceDataFactory() {
        return Stream.of(
                arguments(List.of("cat", "dog", "cow", "tiger", "lion"),
                        ",cat,dog,cow,tiger,lion", ","),
                arguments(List.of("cat", "dog", "cow", "tiger", "lion"),
                        "-cat-dog-cow-tiger-lion", "-"));
    }

    @ParameterizedTest(name = "separator : {2}")
    @MethodSource("reduceDataFactory")
    public void dataAcc(List<String> source, String expected, String separator) {
        String reduceNames = source.stream().reduce("", (acc, next) -> {
            return acc + separator + next;
        });
        assertEquals(expected, reduceNames);
    }

    @Test
    public void dataSum() {
        List<Integer> scores = List.of(1, 2, 3, 4, 5, 6, 7);
        int sum = scores.stream().reduce((a, b) -> a + b).get();
        assertEquals(28, sum);

        double avg = sum / scores.size();
        assertEquals(4, avg);
    }
}
