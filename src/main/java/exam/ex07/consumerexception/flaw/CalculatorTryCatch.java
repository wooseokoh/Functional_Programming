package exam.ex07.consumerexception.flaw;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static exam.ex07.consumerexception.Calculations.DIVISION;

@Slf4j
public class CalculatorTryCatch {
    public static void main(String[] args) {
        //Let's assume this argument is provided in runtime...
        final List<Integer> divisors = List.of(1,0,2,3);

        for (Integer divisor : divisors) {
            try {
                DIVISION.accept(2, divisor);
            }catch (Exception e){
                log.error("Failed to divide....", e);
            }
        }
    }
}
