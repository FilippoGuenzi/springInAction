package _02_spring_on_the_web._05_building_spring_web_applications._03_accepting_request_input._01_query_params;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpittleRepositoryImplementation implements SpittleRepository {

    public List<Spittle> findSpittles(int before, int count) {
        return null;
    }
}
