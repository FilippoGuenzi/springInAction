package _02_spring_on_the_web._05_building_spring_web_applications._02_writing_a_simple_controller._01_testing_the_controller;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class HomeControllerTest {

    @Test
    public void homeTest(){
        HomeController homeController = new HomeController();
        Assert.assertEquals("home", homeController.home());
    }

    @Test
    public void homeTest2() throws Exception{
        HomeController homeController = new HomeController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/jiji")).andExpect(MockMvcResultMatchers.view().name("home"));
    }

}
