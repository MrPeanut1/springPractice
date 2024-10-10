// File: src/main/java/za/ac/cput/springpractice/controller/AuthController.java
package za.ac.cput.springpractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import za.ac.cput.springpractice.api.AuthApi;
import za.ac.cput.springpractice.domain.SupportedGames;
import za.ac.cput.springpractice.domain.UserType;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final AuthApi authApi;

    @Autowired
    public AuthController(AuthApi authApi) {
        this.authApi = authApi;
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("userType", UserType.values());
        return "Login";
    }

    @PostMapping("/loginUser")
    public String login(@RequestParam String firstName, @RequestParam String password, @RequestParam String userType) {
        System.out.println(firstName);
        System.out.println(password);
        boolean isValidUser =authApi.loginUserByUserType( firstName, password, UserType.valueOf(userType.toUpperCase()));
        if (isValidUser && userType.equalsIgnoreCase("player")) {
            return "redirect:/player/home";
        }else if(isValidUser && userType.equalsIgnoreCase("admin")){
            return "redirect:/admin/home";
        }

        return "Error"; //TODO:CHANGE TO VALID ERROR PAGE BUT IGNORE FOR NOW
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("userType", UserType.values());
        model.addAttribute("supportedGames", SupportedGames.values());
        return "Register";
    }

    @PostMapping("/saveUser")
    public String registerUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String password, @RequestParam String userType, @RequestParam String gameSelection, @RequestParam String gamerTag, @RequestParam String gamerTagId) {
        authApi.createUserByUserType(UserType.valueOf(userType.toUpperCase()), SupportedGames.valueOf(gameSelection.toUpperCase()), gamerTag, gamerTagId, password, firstName, lastName);
        return "redirect:/auth/login";
    }
}