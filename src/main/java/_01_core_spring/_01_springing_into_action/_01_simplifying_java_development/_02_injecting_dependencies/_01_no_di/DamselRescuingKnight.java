package _01_core_spring._01_springing_into_action._01_simplifying_java_development._02_injecting_dependencies._01_no_di;

public class DamselRescuingKnight implements Knight{

    private RescueDamselQuest quest;

    public DamselRescuingKnight() {
        this.quest = new RescueDamselQuest();
    }

    public void embarkOnQuest() {
        quest.embark();
    }
}
