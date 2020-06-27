package inc.sneid.rainbowSix.controller;

import inc.sneid.rainbowSix.entity.PersonForm;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/")
    public String show(PersonForm personForm){
        return "form";
    }

    @PostMapping("/")
    public String checkInfo(@Valid PersonForm personForm, BindingResult bindingResult) {
        bindingResult.getAllErrors().forEach(x -> System.out.println(x.toString()));
        if (bindingResult.hasErrors()){
            return "form";
        }
        System.out.println(personForm);
        return "result";
    }

    @GetMapping("/result")
    public String showResult(PersonForm personForm){
        return "result";
    }

}
