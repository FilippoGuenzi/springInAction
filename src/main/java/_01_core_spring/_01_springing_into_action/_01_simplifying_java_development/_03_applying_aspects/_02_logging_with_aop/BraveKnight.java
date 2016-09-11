package _01_core_spring._01_springing_into_action._01_simplifying_java_development._03_applying_aspects._02_logging_with_aop;

public class BraveKnight implements Knight {

    private Quest quest;

    public BraveKnight(Quest quest) {
        this.quest = quest;
    }

    public void embarkOnQuest() {
        quest.embark();
    }
}
