package _02_spring_on_the_web._05_building_spring_web_applications._02_writing_a_simple_controller._02_defining_class_level_request_handling;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = {"/", "/homepage"})
public class HomeController {

    @RequestMapping(value = "jaja", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

}
