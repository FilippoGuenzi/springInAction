package _02_spring_on_the_web._05_building_spring_web_applications._03_accepting_request_input._01_query_params;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

public class SpittleControllerTest {

    @Test
    public void should_list_spittles_list_the_10_first_spittles_when_passed_0_10() throws Exception {
        // Given
        SpittleRepository spittleRepository = mock(SpittleRepository.class);
        SpittleController spittleController = new SpittleController(spittleRepository);
        List<Spittle> tenFirstSpittles = createSpittleList(10);

        MockMvc mvc = standaloneSetup(spittleController)
                .setSingleView(new InternalResourceView("WEB-INF/views/_02/_05/_03/_01/spittles.html"))
                .build();

        // When
        when(spittleRepository.findSpittles(0, 10)).thenReturn(tenFirstSpittles);

        // Then
        mvc
                .perform(get("/spittles?before=0&count=10"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList", tenFirstSpittles));
    }

    private List<Spittle> createSpittleList(int numberOfSpittlesToBeCreated) {
        ArrayList spittles = new ArrayList();
        for (int i = 0; i < numberOfSpittlesToBeCreated; i++) {
            spittles.add(new Spittle("Spittle n°" + i, new Date()));
        }
        return spittles;
    }
}
