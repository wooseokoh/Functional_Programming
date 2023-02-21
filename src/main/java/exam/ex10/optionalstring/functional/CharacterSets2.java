package exam.ex10.optionalstring.functional;

import org.apache.commons.lang3.StringUtils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class CharacterSets2 {

    public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    public Charset of(String charset) {
        return Optional.ofNullable(StringUtils.stripToNull(charset))
                .map(Charset::forName)
                .orElse(DEFAULT_CHARSET);
    }
}