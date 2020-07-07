package inc.sneid.rainbowSix.controller;

import inc.sneid.rainbowSix.Service.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.UUID;

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

    @GetMapping("imageTest")
    public String imageTest(@CookieValue(value = "imgBase64", defaultValue = "") String img,
                            Model model) throws IOException {
        String imgBase64 = img;
        if (!img.isEmpty()) {
            imgBase64 = Base64.getEncoder().encodeToString(new FileInputStream("src/main/resources/static/img/" + img).readAllBytes());
        }
        model.addAttribute("imgBase64", imgBase64);
        return "testImage";
    }

    @PostMapping("imageTest")
    public String image(@RequestParam("upload") MultipartFile upload, Model model, HttpServletResponse response) throws IOException {
        byte[] img = upload.getBytes();
        String imgName = UUID.randomUUID().toString() + upload.getOriginalFilename();
        String pathImg = "src/main/resources/static/img/" + imgName;
        new FileOutputStream(pathImg).write(img);
        Cookie cookie1 = new Cookie("imgBase64", imgName);
        response.addCookie(cookie1);
        return "redirect:/testImage";
    }



}
