package hu.flowacademy.blogpost.service;

import hu.flowacademy.blogpost.dto.UserDTO;
import hu.flowacademy.blogpost.entity.User;
import hu.flowacademy.blogpost.exception.UserAlreadyExistException;
import hu.flowacademy.blogpost.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public void registerUser(UserDTO userDTO) {
        if(userRepository.existsByEmail(userDTO.getEmail())) {
            throw new UserAlreadyExistException();
        }
        var hashedPassword = passwordEncoder.encode(userDTO.getPassword());

        var user = User.builder()
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .email(userDTO.getEmail())
                .password(hashedPassword)
                .build();
        userRepository.save(user);
    }
}
