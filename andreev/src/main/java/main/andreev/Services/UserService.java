package main.andreev.Services;

import lombok.RequiredArgsConstructor;
import main.andreev.models.UserModel;
import main.andreev.models.enums.Role;
import main.andreev.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void createUser(UserModel user){
        if (userRepository.findByLogin(user.getLogin()) != null) return;
        user.setActive(true);
        user.getRoles().add(Role.ROLE_USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
