package _01_core_spring._01_springing_into_action._01_simplifying_java_development._02_injecting_dependencies.listing_1_2_no_di;

import _01_core_spring._01_springing_into_action._01_simplifying_java_development._02_injecting_dependencies.listing_1_2_no_di.DamselRescuingKnight;
import _01_core_spring._01_springing_into_action._01_simplifying_java_development._02_injecting_dependencies.listing_1_2_no_di.RescueDamselQuest;
import org.junit.Test;
import org.mockito.Mockito;

public class DamselRescuingKnightTest {

    //doesn't work cause the mock we've created isn't the one inside the knight. In this knight its dependency is not provided to him but he makes it, and is therefore not available to outside.
    @Test
    public void testEmbarkOnQuest() throws Exception {
        RescueDamselQuest rescueDamselQuest = Mockito.mock(RescueDamselQuest.class);
        DamselRescuingKnight damselRescuingKnight = new DamselRescuingKnight();
        damselRescuingKnight.embarkOnQuest();
        Mockito.verify(rescueDamselQuest).embark();
    }
}
