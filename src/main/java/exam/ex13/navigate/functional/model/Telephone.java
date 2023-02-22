package exam.ex13.navigate.functional.model;

import lombok.Data;

@Data
public class Telephone {

    private PhoneType phoneType;
    private String areaCode;
    private String number;

    public String completeNumber(){
        return String.join("-", this.areaCode, this.number);
    }

    public boolean isTypeOf(PhoneType phoneType){
        return  this.phoneType == phoneType;
    }

    public boolean isHomeNumber(){
        return  isTypeOf(PhoneType.HOME);
    }

    public boolean isMobileNumber(){
        return  isTypeOf(PhoneType.MOBILE);
    }

    public boolean isFaxNumber(){
        return  isTypeOf(PhoneType.FAX);
    }
}