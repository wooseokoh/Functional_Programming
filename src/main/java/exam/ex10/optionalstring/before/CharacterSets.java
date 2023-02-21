package exam.ex10.optionalstring.before;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class CharacterSets {

    public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    public Charset of(String charset) {
        if (charset == null || charset.isEmpty() || charset.isBlank()) {
            return DEFAULT_CHARSET;
        }
        return Charset.forName(charset);
    }
}