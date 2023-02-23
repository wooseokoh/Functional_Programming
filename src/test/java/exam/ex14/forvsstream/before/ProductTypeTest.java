package exam.ex14.forvsstream.before;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductTypeTest {
    private final int repeatTimes = 1000;
    private long totalElapesdTimeNanos;

    @AfterAll
    void printAverageElapsedTime(){
        System.out.println("* Average time in nanoseconds for each call: " + (totalElapesdTimeNanos / repeatTimes * 6));
    }

    @DisplayName("when of(Stirng) is ececuted with many input values, then the expected returns.")
    @ParameterizedTest
    @MethodSource("provideInputAndExpected")
    void test(String input, ProductTypeWithEnumSet expected){
        for(int value = 1; value < repeatTimes; value++){
            final long start = System.nanoTime();
            final Optional<ProductTypeWithEnumSet> result = ProductTypeWithEnumSet.of(input);
            final long end = System.nanoTime();
            totalElapesdTimeNanos += (end - start);
            assertThat(result).isEqualTo(Optional.ofNullable(expected));
        }
    }

    private static Stream<Arguments> provideInputAndExpected(){
        return Stream.of(
                Arguments.of("",null),
                Arguments.of("dda",ProductTypeWithEnumSet.DDA),
                Arguments.of("null",null),
                Arguments.of("credit_CARD",ProductTypeWithEnumSet.CREDIT_CARD),
                Arguments.of("Heloc",ProductTypeWithEnumSet.HELOC),
                Arguments.of("abc",null)
        );
    }
}

/*
ProductType
1. values() & For loog & IF
* Average time in nanoseconds for each call: 56028

ProductTypeWithValueOf
2. values() & Exception handling
* Average time in nanoseconds for each call: 360300

ProductTypeWithMap
3. Map<String, ProductType>
* Average time in nanoseconds for each call: 11412

ProductTypeWithStream
4. Arrays.stream(ProductType.values())
* Average time in nanoseconds for each call: 89346

ProductTypeWithEnumSet
5. EnumSet.allOf(ProductType.class).stream()
* Average time in nanoseconds for each call: 96246
 */
