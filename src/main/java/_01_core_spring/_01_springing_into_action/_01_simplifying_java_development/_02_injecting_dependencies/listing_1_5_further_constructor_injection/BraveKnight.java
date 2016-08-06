package _01_core_spring._01_springing_into_action._01_simplifying_java_development._02_injecting_dependencies.listing_1_5_further_constructor_injection;

public class BraveKnight implements Knight {

    private Quest quest;

    public BraveKnight(Quest quest) {
        this.quest = quest;
    }

    public void embarkOnQuest(){
        quest.embark();
    }
}
