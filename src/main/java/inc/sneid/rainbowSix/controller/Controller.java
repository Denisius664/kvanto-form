package inc.sneid.rainbowSix.controller;

import inc.sneid.rainbowSix.Service.MailSender;
import inc.sneid.rainbowSix.entity.ImagesForm;
import inc.sneid.rainbowSix.entity.PersonForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.io.IOException;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/")
    public String show(PersonForm personForm){
        return "form";
    }

    @PostMapping("/")
    public String checkInfo(@Valid PersonForm personForm, BindingResult result, ImagesForm imagesForm) throws IOException {
        result.getAllErrors().forEach(x -> System.out.println(x.toString()));
        if (result.hasErrors()){
            return "form";
        }

        System.out.println(personForm);
        System.out.println(imagesForm);
        return "redirect:/result";
    }

    @GetMapping("/result")
    public String showResult() {
        return "result";
    }

}
