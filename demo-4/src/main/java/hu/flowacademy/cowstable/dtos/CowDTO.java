package hu.flowacademy.cowstable.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class CowDTO {
    @JsonProperty("sid")
    @Pattern(regexp = "^\\d{3}-\\d{4}-\\d{3}$")
    private String serialId;
    @JsonProperty("size")
    private Integer age;
    @JsonProperty("stable")
    private Long stableId;
}
