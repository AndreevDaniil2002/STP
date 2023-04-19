package main.andreev.controller;

import lombok.RequiredArgsConstructor;
import main.andreev.Services.UserService;
import main.andreev.models.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }


    @PostMapping("/registration ")
    public String createUser(UserModel user) {
        userService.createUser(user);
        return "redirect:/login";
    }
}
