package exam.ex15.reusestream;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.List;

@Slf4j
public class ReuseStream4 {


    public static void main(String[] args) {
        final Collection<String> collection = List.of("Ant", "cHick3n", "bIrd", "123?");

        final List<String> uppercased = collection.stream()
                .filter(StringUtils::isAlphanumeric)
                .map(String::toUpperCase)
                .toList();
        log.debug("Uppercased: {}", uppercased);

        final List<String> lowercased = collection.stream()
                .filter(StringUtils::isAlphanumeric)
                .map(String::toLowerCase)
                .toList();
        log.debug("Lowercased: {}", lowercased);
    }
    // 조금 중복 되더라도 stream을 리턴하는 메소드나 유틸은 안만드는것이.. ex.StreamUtils3
    // reason. alphabetsOnlyAndMap = 새로운 stream이 생성되는지 확인 필요하고 값의 변경유무 확인도 확인해야됨 result.타협하자
}