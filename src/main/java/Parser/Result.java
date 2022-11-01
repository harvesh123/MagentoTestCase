package Parser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Data
@Getter
@Setter
@JsonIgnoreProperties({"dob","registered","picture"})
public class Result {
    String gender;
    String email;
    String phone;
    String cell;
    String nat;
    Name name;
    Location location;
    Login login;
    ID id;
}
