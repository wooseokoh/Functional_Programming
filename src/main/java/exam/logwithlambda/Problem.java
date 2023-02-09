package exam.logwithlambda;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.List;

@Slf4j
public class Problem {

    public static void main(String[] args) {
        final boolean traceEnabled = log.isTraceEnabled();
        if(log.isTraceEnabled()){
            log.trace("Print some debug information... {}", timeConsumingJob());
        }
        System.out.println("Done.");
    }

    private static List<Integer> timeConsumingJob(){
        return IntStream.range(1, Integer.MAX_VALUE)
                .filter(number -> number % 2 == 0)
                .boxed()
                .collect(Collectors.toList());
    }
}
