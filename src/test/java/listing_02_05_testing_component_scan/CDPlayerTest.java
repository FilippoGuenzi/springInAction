package listing_02_05_testing_component_scan;

import _01_core_spring._02_wiring_beans._02_automatically_wiring_beans._01_creating_discoverable_beans._01_java_component_scanning.CDPlayerConfig;
import _01_core_spring._02_wiring_beans._02_automatically_wiring_beans._01_creating_discoverable_beans._01_java_component_scanning.CompactDisc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {

    @Autowired
    private CompactDisc cd;

    @Test
    public void cd_should_not_be_null() {
        assertNotNull(cd);
    }
}
