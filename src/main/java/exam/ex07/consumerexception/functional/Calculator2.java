package exam.ex07.consumerexception.functional;

import java.util.List;

import static exam.ex07.consumerexception.Calculations.*;

public class Calculator2 {
    public static void main(String[] args) {

        final List<Integer> dividends = List.of(1,2,3);

        dividends.forEach(dividend ->
                LambdaWrappers.wrapThrwosException(DIVISION)
                        .accept(2, dividend)
        );

        dividends.forEach(dividend ->
                LambdaWrappers.wrapContinue(DIVISION)
                        .accept(2, dividend)
        );

        dividends.forEach(dividend ->
                LambdaWrappers.wrapContinueSelectively(DIVISION, ArithmeticException.class)
                        .accept(2, dividend)
        );

        dividends.forEach(dividend ->
                LambdaWrappers.wrapContinueSelectively(DIVISION, ArithmeticException.class, e -> ...)
                        .accept(2, dividend)
        );
    }
}
