package inc.sneid.kvantoForm.controller;

import inc.sneid.kvantoForm.entity.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
public class MainController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/result").setViewName("result");
    }

    @GetMapping("/")
    public String onGet(Profile profile){
        System.out.println("get");
        return "index";
    }

    @PostMapping("/")
    public String checkPersonInfo(@Valid @ModelAttribute(name = "profile") Profile profile, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "index";
        }
        System.out.println(profile.toString());

        return "redirect:/result";
    }

}
