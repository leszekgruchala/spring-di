package eu.gruchala.spring.profile;

import eu.gruchala.spring.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.Assert.assertEquals;

/**
 * @author lgr
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@ActiveProfiles("test")
public class ActiveProfileUsageTest {

    @Autowired
    private String profileName;

    @Test
    public void testActiveProfile() {
        assertEquals(profileName, "Test profile");
    }
}
