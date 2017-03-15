package _02_spring_on_the_web._05_building_spring_web_applications._03_accepting_request_input._01_query_params;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class SpittleRepositoryImplementation implements SpittleRepository {

    public List<Spittle> findSpittles(int before, int count) {
        ArrayList<Spittle> spittles = new ArrayList<Spittle>();
        spittles.add(new Spittle("yoyo", new Date(), 3.1d, 2.5d));
        return spittles;
    }
}
