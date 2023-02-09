package exam.logwithlambda;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution2 {

    private final static MySlf4jLogger logger = new MySlf4jLogger();

    public static void main(String[] args) {
        logger.trace("Print some debug information... {}", () -> timeConsumingJob());
        System.out.println("Done.");
    }

    private static List<Integer> timeConsumingJob(){
        return IntStream.range(1, Integer.MAX_VALUE)
                .filter(number -> number % 2 == 0)
                .boxed()
                .collect(Collectors.toList());
    }
}
