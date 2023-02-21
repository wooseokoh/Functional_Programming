package exam.ex10.optionalstring.functional;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CharacterSets3 {

    private final CharsetFinder charsetFinder;

    public Charset ofDefaultedUtf8(String charset, Charset defaultCharset) {
        return Optional.ofNullable(StringUtils.stripToNull(charset))
                .map(Charset::forName)
                .or(CharacterSets3::orSecond)
                .or(CharacterSets3::orThird)
                .orElse(defaultCharset);
    }

    public static Optional<Charset> orSecond() {
        return Optional.of(StandardCharsets.ISO_8859_1);
    }

    public static Optional<Charset> orThird() {
        return Optional.of(StandardCharsets.US_ASCII);
    }

    public Charset ofConsultingService(String charset){
        return Optional.ofNullable(charset)
                .map(value -> value.isBlank() ? null : value)
                .map(Charset::forName)
                .or(CharacterSets3::orSecond)
                .or(CharacterSets3::orThird)
                .orElseGet(charsetFinder::findDefaultCharset);
    }
}
