package exam.filterbypredicate;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

// 반복적인 코드
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NumberUtils1 {

    public static List<Integer> getOddNumbers(List<Integer> numbers){
        return numbers.stream()
                .filter(Objects::nonNull)
                .filter(number -> number % 2 != 0)
                .collect(Collectors.toList());
    }

    public static List<Integer> getEvenNumbers(List<Integer> numbers){
        return numbers.stream()
                .filter(Objects::nonNull)
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());
    }

//    public List<Integer> getOddNumbers(List<Integer> numbers){
//        final List<Integer> result = new ArrayList<>();
//        for (Integer number : numbers){
//            if( number == null){
//                continue;
//            }
//            if( number % 2 != 0){
//                result.add(number);
//            }
//        }
//        return result;
//    }
//
//    public List<Integer> getEvenNumbers(List<Integer> numbers){
//        final List<Integer> result = new ArrayList<>();
//        for (Integer number : numbers){
//            if( number == null){
//                continue;
//            }
//            if( number % 2 == 0){
//                result.add(number);
//            }
//        }
//        return result;
//    }
}
