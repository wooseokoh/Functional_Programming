package exam.ex11.optionalnpe.flaw;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

public class AvoidNPE {

    public String uppercaseValue(Pair<String, String> pair, String searchKey){
        if(pair == null){
            return  null;
        }
        if(StringUtils.equalsIgnoreCase(pair.getKey(), searchKey)){
            return StringUtils.upperCase(pair.getValue());
        }
        return null;
    }
}
