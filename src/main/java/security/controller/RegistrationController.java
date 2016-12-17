package security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import security.dto.UserTO;
import security.model.User;
import security.service.UserService;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/sign-up", method = RequestMethod.GET)
    public String profile(WebRequest request, Model model, Principal principal) {
        if (principal != null) return "redirect:welcome";
        UserTO userTO = new UserTO();
        model.addAttribute("user", userTO);
        return "signUp";
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public String register(Model model, @ModelAttribute("user") @Valid UserTO userTO,
                                 BindingResult result, WebRequest request, Errors errors) {
        User registered = userService.registerNewUserAccount(userTO);
        if (registered == null) {
            result.rejectValue("login", "message.regError");
            model.addAttribute("user", userTO);
            return "sign-up";
        }

        return "redirect:welcome";
    }
}
