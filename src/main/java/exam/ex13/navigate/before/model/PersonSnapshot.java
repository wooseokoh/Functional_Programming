package exam.ex13.navigate.before.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonSnapshot {

    private String name;
    private String homeNumber;
    private String mobileNumber;
    private String dependentNames;  //in CSV
    private String siblingNames;    //in CSV
}