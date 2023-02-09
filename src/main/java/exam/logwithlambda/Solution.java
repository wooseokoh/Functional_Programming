package exam.logwithlambda;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.util.Supplier;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Log4j2
public class Solution {
    public static void main(String[] args) {

        log.trace("Print some debug information... {}", () -> timeConsumingJob());
        System.out.println("Done.");
    }

    private static List<Integer> timeConsumingJob(){
        return IntStream.range(1, Integer.MAX_VALUE)
                .filter(number -> number % 2 == 0)
                .boxed()
                .collect(Collectors.toList());
    }
}