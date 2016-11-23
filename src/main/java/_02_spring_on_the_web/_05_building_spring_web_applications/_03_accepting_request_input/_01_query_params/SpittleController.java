package _02_spring_on_the_web._05_building_spring_web_applications._03_accepting_request_input._01_query_params;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class SpittleController {

    private final SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(value = "/spittles", method = RequestMethod.GET)
    public String listSpittles(int before, int count){
        spittleRepository.findSpittles(before, count);
        return "spittles";
    }
}
