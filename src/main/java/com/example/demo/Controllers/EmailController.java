package com.example.demo.Controllers;

import com.example.demo.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/sendmail")
//public class EmailController {
//
//    @Autowired
//    private EmailService emailService;
//
//    @GetMapping("/{to}/{text}")
//    public String sendEmail(@PathVariable String to,@PathVariable String text){
//        emailService.sendSimpleMessage(to,text);
//        return "mail sent";
//    }
//
//}
