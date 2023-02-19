package exam.ex07.consumerexception.flaw;

import java.util.List;

import static exam.ex07.consumerexception.Calculations.DIVISION;

public class CalculatorHappyPath {
    public static void main(String[] args) {
        //Let's assume this argument is provided in runtime...
        final List<Integer> divisors = List.of(1,2,3);

        for (Integer divisor : divisors) {
            DIVISION.accept(2, divisor);
        }
    }
}
