package security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import security.service.UserService;
import security.util.GreetingUser;

@Controller
public class RootController {

    @Autowired
    private UserService userService;

    @Autowired
    private GreetingUser greetingUser;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root() {
        return "redirect:welcome";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(Model model) {
        model.addAttribute("greet",greetingUser.getGreetingPhrase());
        return "welcome";
    }

    @RequestMapping(value = "/sign-in", method = RequestMethod.GET)
    public String loginPage(Model model) {
        return "signIn";
    }
}
