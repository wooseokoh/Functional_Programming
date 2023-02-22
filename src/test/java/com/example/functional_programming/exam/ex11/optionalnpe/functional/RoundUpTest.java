package com.example.functional_programming.exam.ex11.optionalnpe.functional;

import exam.ex11.optionalnpe.functional.RoundUp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RoundUpTest {

    private final RoundUp subject = new RoundUp();

    @Test
    @DisplayName("when the input is null, an empty optional returns.")
    void whenTheInputIsNullAnEmptyOptionalReturns(){
        final Optional<BigDecimal> result = subject.halfUp(null, new Random().nextInt(10) + 1);
        assertThat(result).isEmpty();
    }

    @Test
    @DisplayName("when the input .toString() is not a number format, an empty optional returns.")
    void whenTheInputToStringIsNotNumberFormatAnEmptyOptionalReturns(){
        final Object input = mock(Object.class);
        when(input.toString()).thenReturn("abc123");
        final Optional<BigDecimal> result = subject.halfUp(input, new Random().nextInt(10) + 1);
        assertThat(result).isEmpty();
    }

    @Test
    @DisplayName("when the input .toString() is a number format, Optional of valid value returns.")
    void whenTheInputToStringIsNotNumberFormatOptionalOfValidValueReturns(){
        final Object input = mock(Object.class);
        when(input.toString()).thenReturn(" 123.456 ");
        final Optional<BigDecimal> result = subject.halfUp(input, 2);
        assertThat(result).contains(new BigDecimal("123.46").setScale(2));
    }
}
