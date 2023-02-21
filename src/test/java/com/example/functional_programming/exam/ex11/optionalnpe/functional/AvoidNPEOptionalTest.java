package com.example.functional_programming.exam.ex11.optionalnpe.functional;

import exam.ex11.optionalnpe.functional.AvoidNPEOptional;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AvoidNPEOptionalTest {

    private final AvoidNPEOptional subject = new AvoidNPEOptional();

    @Test
    @DisplayName("when the input is null, an empty Optional returns.")
    void whenTheInputIsNullAnEmptyOptionalReturns(){
        assertThat(subject.uppercaseValue(null,"key")).isEmpty();
    }

    @Test
    @DisplayName("when the input key is not matched, an empty Optional returns.")
    void whenTheInputKeyIsNotMatchedAnEmptyOptionalReturns(){
        final Pair<String, String> input = Pair.of("Key", "something");
        assertThat(subject.uppercaseValue(input,"Key2")).isEmpty();
    }

    @Test
    @DisplayName("when the input key is matched but the value is null, an empty Optional returns.")
    void whenTheInputKeyIsMatchedButTheValueIsNullAnEmptyOptionalReturns(){
        final Pair<String, String> input = Pair.of("Key", null);
        assertThat(subject.uppercaseValue(input,"Key")).isEmpty();
    }

    @Test
    @DisplayName("when the input key is matched and the value is not null, its value returns being uppercased")
    void whenTheInputKeyIsMatchedAndTheValueIsNotNullItsValueIsUppercased(){
        final Pair<String, String> input = Pair.of("key", "something");
        assertThat(subject.uppercaseValue(input,"Key")).hasValue("SOMETHING");
    }
}
