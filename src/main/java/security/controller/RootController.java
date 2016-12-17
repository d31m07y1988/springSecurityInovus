package security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String welcome(Model model, Principal principal) {
        model.addAttribute("greet", greetingUser.getGreetingPhrase());
        model.addAttribute("userName", principal.getName());
        return "welcome";
    }


    @RequestMapping(value = "/sign-in", method = RequestMethod.GET)
    public String loginPage(Model model, Principal principal, @RequestParam(value="error", required=false) boolean error) {
        if (principal != null) return "redirect:welcome";
        if (error==true) model.addAttribute("error", "имя пользователя и пароль не подходят");
        return "signIn";
    }
}
