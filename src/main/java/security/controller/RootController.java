package security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import security.util.GreetingUser;

import java.security.Principal;

@Controller
public class RootController {

    @Autowired
    @Lazy
    private GreetingUser greetingUser;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root() {
        return "redirect:welcome";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(Model model) {
        model.addAttribute("greet", greetingUser.getGreetingPhrase());
        return "welcome";
    }


    @RequestMapping(value = "/sign-in", method = RequestMethod.GET)
    public String loginPage(Model model, Principal principal) {
        if (principal != null) return "redirect:welcome";
        return "signIn";
    }
}
