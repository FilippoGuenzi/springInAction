package _01_core_spring._02_wiring_beans._05_importing_and_mixing_configurations._02_import_xml_config_into_xml_config;

public class CDPlayer {

    private CompactDisc cd;

    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    public void play() {
        cd.play();
    }
}
