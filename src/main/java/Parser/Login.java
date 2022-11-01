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
@JsonIgnoreProperties({"uuid","salt","md5","sha1","sha256"})
public class Login {
    String username;
    String password;
}
