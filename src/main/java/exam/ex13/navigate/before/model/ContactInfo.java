package exam.ex13.navigate.before.model;

import java.util.Collection;

import lombok.Data;

@Data
public class ContactInfo {

    private Collection<Telephone> phoneNumbers;
}