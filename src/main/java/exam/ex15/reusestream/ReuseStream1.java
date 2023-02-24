package exam.ex15.reusestream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class ReuseStream1 {

    public static void main(String[] args) {
        final Collection<String> collection = List.of("Ant", "cHick3n", "bIrd", "123?");

//        final List<String> lowercasedList = new ArrayList<>();
//        for(String s1 : collection){
//            if(StringUtils.isAlphanumeric(s1)){
//                String toLowerCase = s1.toLowerCase();
//                lowercasedList.add(toLowerCase);
//            }
//        }

        final List<String> lowercasedList = collection.stream()
                .filter(StringUtils::isAlphanumeric)
                .map(String::toLowerCase)
                .toList();
        log.debug("Lowercased: {}", lowercasedList);

//        final List<String> uppercasedList = new ArrayList<>();
//        for(String s1 : collection){
//            if(StringUtils.isAlphanumeric(s1)){
//                String toUpperCase = s1.toUpperCase();
//                uppercasedList.add(toUpperCase);
//            }
//        }

        final List<String> uppercasedList = collection.stream()
                .filter(StringUtils::isAlphanumeric)
                .map(String::toUpperCase)
                .toList();
        log.debug("Uppercased: {}", uppercasedList);
    }
}