package hu.flowacademy.blogpost.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserDTO {
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
}
