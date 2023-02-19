package exam.ex07.consumerexception.functional;

import java.util.List;

import static exam.ex07.consumerexception.Calculations.DIVISION_STOP;
import static exam.ex07.consumerexception.Calculations.DIVISION_CONTINUED;

public class Calculator1 {
    public static void main(String[] args) {

        final List<Integer> dividends = List.of(1,2,3);
        dividends.forEach(dividend ->
                DIVISION_STOP.accept(2, dividend)
        );

        dividends.forEach(dividend ->
                DIVISION_CONTINUED.accept(2, dividend)
        );
    }
}
