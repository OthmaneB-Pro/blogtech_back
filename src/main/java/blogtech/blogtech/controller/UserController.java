package blogtech.blogtech.controller;

import blogtech.blogtech.entity.User;
import blogtech.blogtech.security.JwtUtil;
import blogtech.blogtech.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping(path = "user")
public class UserController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @GetMapping
    public List<User> readAll(){
        return this.userService.readAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void register(@RequestBody User user){
        this.userService.register(user);
    }

    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody User loginRequest){
        User user = userService.login(loginRequest.getUsername(), loginRequest.getPassword());
        if (user != null) {

            String token = jwtUtil.generateToken(userService.loadUserByUsername(user.getUsername()));


            Map<String, Object> response = new HashMap<>();
            response.put("user", user);
            response.put("token", token);

            return ResponseEntity.ok(response);
        }
        throw new IllegalArgumentException("Invalid Credential");
        }
}
