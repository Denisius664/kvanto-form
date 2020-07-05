package inc.sneid.rainbowSix.controller;

import inc.sneid.rainbowSix.Service.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TestController {

    @Autowired
    private MailSender mailSender;

    @GetMapping("testMail")
    public String mailGet(){
        return "emailTest";
    }

    @PostMapping("testMail")
    public String mail(String mail){
        System.out.println(mail);
        mailSender.send(mail, "Test", "Я тестирую почту");
        return "emailTest";
    }

}
