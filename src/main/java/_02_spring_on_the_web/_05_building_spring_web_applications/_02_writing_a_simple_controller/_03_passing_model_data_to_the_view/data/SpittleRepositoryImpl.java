package _02_spring_on_the_web._05_building_spring_web_applications._02_writing_a_simple_controller._03_passing_model_data_to_the_view.data;

import _02_spring_on_the_web._05_building_spring_web_applications._02_writing_a_simple_controller._03_passing_model_data_to_the_view.entities.Spittle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class SpittleRepositoryImpl implements SpittleRepository {
    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> spittleList = new ArrayList<Spittle>();
        spittleList.add(new Spittle("Message 1", new Date()));
        spittleList.add(new Spittle("Message 2", new Date()));
        spittleList.add(new Spittle("Message 3", new Date(), 4.53621654, 5.68432121));
        return spittleList;
    }
}
