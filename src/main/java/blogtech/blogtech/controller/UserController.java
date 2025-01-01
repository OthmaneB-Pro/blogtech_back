package blogtech.blogtech.controller;

import blogtech.blogtech.entity.User;
import blogtech.blogtech.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(name = "user")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> readAll(){
        return this.userService.readAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void register(User user){
        this.userService.register(user);
    }
}
