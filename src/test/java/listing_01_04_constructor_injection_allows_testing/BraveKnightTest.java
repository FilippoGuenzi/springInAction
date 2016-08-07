package listing_01_04_constructor_injection_allows_testing;

import _01_core_spring._01_springing_into_action._01_simplifying_java_development._02_injecting_dependencies.listing_01_03_constructor_injection.BraveKnight;
import _01_core_spring._01_springing_into_action._01_simplifying_java_development._02_injecting_dependencies.listing_01_03_constructor_injection.Quest;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class BraveKnightTest {

    @Test
    public void testEmbarkOnQuest() throws Exception {
        Quest quest = mock(Quest.class);
        BraveKnight knight = new BraveKnight(quest);
        knight.embarkOnQuest();
        verify(quest, times(1)).embark();
    }
}
