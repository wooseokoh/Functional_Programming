package exam.ex13.navigate.before.model;

import lombok.Data;

@Data
public
class Telephone {

    private PhoneType phoneType;
    private String areaCode;
    private String number;
}