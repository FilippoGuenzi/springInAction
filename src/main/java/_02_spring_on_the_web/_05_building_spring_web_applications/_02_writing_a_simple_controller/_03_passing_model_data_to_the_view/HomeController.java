package _02_spring_on_the_web._05_building_spring_web_applications._02_writing_a_simple_controller._03_passing_model_data_to_the_view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = {"/", "/top"})
public class HomeController {

    @RequestMapping(value = {"yoyo", "yeye"}, method = RequestMethod.GET)
    public String home(){
        return "home";
    }

}
