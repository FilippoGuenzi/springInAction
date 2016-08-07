package listing_in_02_02_05;

import _01_core_spring._02_wiring_beans._02_automatically_wiring_beans._05_verifying_automatic_configuration.listing_in_02_02_05.CompactDisc;
import _01_core_spring._02_wiring_beans._02_automatically_wiring_beans._05_verifying_automatic_configuration.listing_in_02_02_05.MediaPlayer;
import _01_core_spring._02_wiring_beans._02_automatically_wiring_beans._05_verifying_automatic_configuration.listing_in_02_02_05.SpringConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class MediaPlayerTest {

    @Autowired
    private MediaPlayer mp;

    @Autowired
    private CompactDisc cd;

    @Test
    public void cd_log_should_be_consistent() {
        //Arrange
        //Act
        mp.play();
        //Assert
        Assert.assertEquals(cd.getLog(), "CD Prince and the Revolution by Prince is being played");
    }
}
