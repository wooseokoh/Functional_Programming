package exam.ex13.navigate.functional.model;

import lombok.Data;

import java.util.Collection;
import org.apache.commons.collections4.CollectionUtils;

@Data
public class ContactInfo {

    private Collection<Telephone> telephones;

    public Collection<Telephone> getTelephones(){
        return CollectionUtils.emptyIfNull(this.telephones);
    }
}