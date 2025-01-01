package blogtech.blogtech.service;

import blogtech.blogtech.entity.User;
import blogtech.blogtech.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<User> readAll() {
        return this.userRepository.findAll();
    }

    public void register(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.userRepository.save(user);
    }


}
