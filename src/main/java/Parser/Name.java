package Parser;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Data
@Getter
@Setter
public class Name {
    String title;
//    @SerializedName(value = first)
    String first;
    String last;
}
