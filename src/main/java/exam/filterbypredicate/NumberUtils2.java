package exam.filterbypredicate;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// 또 다른 요구사항이 들어올경우
// 다른 메소드 추가 필요
// 재사용성 저조
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NumberUtils2 {

    public List<Integer> getOddNumbers(List<Integer> numbers){
        return filterBy(numbers, number -> number % 2 != 0);
    }

    public List<Integer> getEvenNumbers(List<Integer> numbers){
        return filterBy(numbers, number -> number % 2 == 0);
    }

    static <T> List<T> filterBy(List<T> list, Predicate<T> predicate){
        return list.stream()
                .filter(Objects::nonNull)
                .filter(predicate)
                .collect(Collectors.toList());
    }

//    public List<Integer> getOddNumbers(List<Integer> numbers){
//        return getOddOrEvenNumbers(numbers, 1);
//    }
//
//    public List<Integer> getEvenNumbers(List<Integer> numbers){
//        return getOddOrEvenNumbers(numbers, 0);
//    }
//
//    public List<Integer> getOddOrEvenNumbers(List<Integer> numbers, int remainder){
//        final List<Integer> result = new ArrayList<>();
//        for (Integer number : numbers){
//            if( number == null){
//                continue;
//            }
//            if( number % 2 == remainder){
//                result.add(number);
//            }
//        }
//        return result;
//    }
}
