package _02_spring_on_the_web._05_building_spring_web_applications._02_writing_a_simple_controller._03_passing_model_data_to_the_view.data;

import _02_spring_on_the_web._05_building_spring_web_applications._02_writing_a_simple_controller._03_passing_model_data_to_the_view.entities.Spittle;

import java.util.List;

public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
}
