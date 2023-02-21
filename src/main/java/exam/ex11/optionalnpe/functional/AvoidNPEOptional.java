package exam.ex11.optionalnpe.functional;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Locale;
import java.util.Optional;

public class AvoidNPEOptional {

    public Optional<String> uppercaseValue(Pair<String, String> input, String searchKey){
        return Optional.ofNullable(input)
                .filter(pair -> StringUtils.equalsIgnoreCase(pair.getKey(), searchKey))
                .map(Pair::getValue)
                .map(String::toUpperCase);
    }
}
