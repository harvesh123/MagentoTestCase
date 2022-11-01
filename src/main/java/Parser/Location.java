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
@JsonIgnoreProperties({"timezone","coordinates"})
public class Location {
    Street street;
    String city;
    String state;
    String country;
    String postcode;
}
