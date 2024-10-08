package za.ac.cput.springpractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import za.ac.cput.springpractice.domain.Player;
import za.ac.cput.springpractice.factory.PlayerFactory;
import za.ac.cput.springpractice.service.PlayerServiceImpl;

@Controller
@RequestMapping("/player")
public class PlayerController {


    @GetMapping("/home")
    public String home(){
        return "PlayerHome";
    }

}