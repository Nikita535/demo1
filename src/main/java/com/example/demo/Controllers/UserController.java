package com.example.demo.Controllers;


import com.example.demo.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final PasswordEncoder encoder;

    private final static InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();

    @GetMapping("/register")
    public String getForm(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    @PostMapping("/register")
    public @ResponseBody
    String registerAcc(@ModelAttribute("user") @Valid com.example.demo.entity.User user){
        if(userDetailsManager.userExists(user.getUsername()))
            return "User already exists";
        else
            userDetailsManager.createUser(new org.springframework.security.core.userdetails.User
                    (user.getUsername(), encoder.encode(user.getPassword()),
                            List.of(new SimpleGrantedAuthority("ROLE_USER"))));
        return "Success";
    }

    public static UserDetailsService userDetailsService() {return userDetailsManager;}



}
