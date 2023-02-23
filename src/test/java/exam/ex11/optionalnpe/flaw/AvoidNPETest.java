package exam.ex11.optionalnpe.flaw;

import exam.ex11.optionalnpe.flaw.AvoidNPE;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AvoidNPETest {

    private final AvoidNPE subject = new AvoidNPE();

    @Test
    @DisplayName("when the input is null, null returns.")
    void whenTheInputIsNullNullReturns(){
        assertThat(subject.uppercaseValue(null,"key")).isNull();
    }

    @Test
    @DisplayName("when the input key is not matched, null returns.")
    void whenTheInputKeyIsNotMatchedNullReturns(){
        final Pair<String, String> input = Pair.of("Key", "something");
        assertThat(subject.uppercaseValue(input,"Key2")).isNull();
    }

    @Test
    @DisplayName("when the input key is matched but the value is null, null returns.")
    void whenTheInputKeyIsMatchedButTheValueIsNullNullReturns(){
        final Pair<String, String> input = Pair.of("Key", null);
        assertThat(subject.uppercaseValue(input,"Key")).isNull();
    }

    @Test
    @DisplayName("when the input key is matched and the value is not null, its value returns being uppercased")
    void whenTheInputKeyIsMatchedAndTheValueIsNotNullItsValueIsUppercased(){
        final Pair<String, String> input = Pair.of("key", "something");
        assertThat(subject.uppercaseValue(input,"Key")).isEqualTo("SOMETHING");
    }
}
