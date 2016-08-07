package _01_core_spring._02_wiring_beans._02_automatically_wiring_beans._05_verifying_automatic_configuration.listing_in_02_02_05;

import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer implements MediaPlayer {
    private CompactDisc cd;

    @Autowired
    public void insertCD(CompactDisc cd) {
        this.cd = cd;
    }

    public void play() {
        cd.play();
    }
}
