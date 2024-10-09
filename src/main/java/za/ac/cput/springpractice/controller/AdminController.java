package za.ac.cput.springpractice.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import za.ac.cput.springpractice.service.AdminServiceImpl;



@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private final AdminServiceImpl adminServiceImpl;

    public AdminController(AdminServiceImpl adminServiceImpl) {
        this.adminServiceImpl = adminServiceImpl;
    }

    @GetMapping("/home")
    public String home(HttpServletRequest request, Model model){
        String sessionId = request.getSession().getId();

        model.addAttribute("sessionId", "SESSIONID: " + sessionId);

        return "AdminHome";
    }





}
