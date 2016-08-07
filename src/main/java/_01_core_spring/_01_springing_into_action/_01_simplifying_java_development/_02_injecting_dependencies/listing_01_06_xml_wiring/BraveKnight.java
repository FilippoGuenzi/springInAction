package _01_core_spring._01_springing_into_action._01_simplifying_java_development._02_injecting_dependencies.listing_01_06_xml_wiring;

public class BraveKnight implements Knight {

    private Quest quest;

    public BraveKnight(Quest quest) {
        this.quest = quest;
    }

    public void embarkOnQuest(){
        quest.embark();
    }
}
