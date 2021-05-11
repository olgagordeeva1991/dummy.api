package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Owner {
    private String id;
    private String firstName;
    private String lastName;
}
