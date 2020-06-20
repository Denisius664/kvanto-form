package inc.sneid.rainbowSix.controller;

import inc.sneid.rainbowSix.entity.PersonForm;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@org.springframework.stereotype.Controller
public class Controller implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/result").setViewName("result");
    }

    @GetMapping("/")
    public String show(PersonForm personForm){
        return "form";
    }

    @PostMapping("/")
    public String checkInfo(@Valid PersonForm personForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "form";
        }
        return "redirect:/result";
    }

}
