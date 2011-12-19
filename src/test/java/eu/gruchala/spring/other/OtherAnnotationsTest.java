package eu.gruchala.spring.other;

import eu.gruchala.spring.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.annotation.Timed;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p/>
 *
 * @author lgr
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class OtherAnnotationsTest {

    @Test
    @Timed(millis = 100)
    public void testShouldPassInLessThan1Sec() {
        try {
            Thread.sleep(90);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    @IfProfileValue(name = "java.vendor", value = "Sun Microsystems Inc.")
    public void testShouldRunOnlyOnSunJvm() {
        System.out.println(String.format("Was invoked in JVM: %s", System.getenv("java.vendor")));
    }

    @Test
    @Repeat(5)
    public void testShouldRepeat5Times() {
        System.out.println("I like to be invoked many times.");
    }
}
