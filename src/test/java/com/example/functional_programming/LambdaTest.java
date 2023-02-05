package com.example.functional_programming;

import com.example.functional_programming.lambda.Operator;
import com.example.functional_programming.lambda.Plus;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LambdaTest {

    @Test
    public void java_anonymous_class(){
        Plus plus = new Plus() {
            @Override
            public int operate(int x, int y) {
                return x+y;
            }
        };
        int resultValue = plus.operate(2,5);
        assertEquals(7, resultValue);
    }

    @Test
    public void java_lambda_abstract_anonymous_class(){
        Plus plus = (x,y) -> x + y;
        assertEquals(7, plus.operate(2,5));
    }

    @Test
    public void multi_layer(){
        Plus plus = (x,y) -> {
            int result = x + y;
            return result;
        };
        assertEquals(7, plus.operate(2,5));
    }

    @Test
    public void function_parameter(){
        int result = operator((x,y) -> x + y, 2,5);
        assertEquals(7, result);
        result = operator((x,y) -> x - y, 2,5);
        assertEquals(-3, result);
    }

    private int operator(Operator operator, int x, int y){
        return operator.operate(x,y);
    }
}
