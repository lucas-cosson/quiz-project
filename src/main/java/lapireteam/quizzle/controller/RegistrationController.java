package lapireteam.quizzle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import lapireteam.quizzle.entity.RegistrationForm;
import lapireteam.quizzle.entity.User;
import lapireteam.quizzle.repository.UserRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private PasswordEncoder encoder;
    private UserRepository userRepository;

    @Autowired
    public RegistrationController(PasswordEncoder encoder, UserRepository userRepository) {
        this.encoder = encoder;
        this.userRepository = userRepository;
    }

    @InitBinder
    public void webBinder(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @GetMapping({"", "/"})
    public String getRegister(Model model) {
        RegistrationForm registrationForm = new RegistrationForm();
        model.addAttribute("reg", registrationForm);

        return "register";
    }

    @PostMapping({"", "/"})
    public String processRegister(@Valid @ModelAttribute("reg") RegistrationForm form, BindingResult errors) {
        if (errors.hasErrors()) {
            return "register";
        }
        User user = form.toUser(encoder);
        userRepository.save(user);

        return "redirect:/login";
    }

}
