package exam.ex10.optionalstring.functional;

import io.micrometer.common.util.StringUtils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class CharacterSets1 {

    public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    public Charset of(String charset) {
        return Optional.ofNullable(charset)
                .filter(StringUtils::isNotBlank)
                .map(Charset::forName)
                .orElse(DEFAULT_CHARSET);
    }
}