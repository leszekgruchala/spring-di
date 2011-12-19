package eu.gruchala.spring.listener;

import eu.gruchala.spring.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author lgr
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@TestExecutionListeners(listeners = VerboseTestExecutionListener.class)
public class ExecutionListenerTest {

    @Test
    public void testFirst() {
        System.out.println("Ha! I'm first!");
    }

    @Test
    public void testSecond() {
        System.out.println(" I'm second!");
    }

    @Test
    public void testThird() {
        System.out.println("Ha! I'm third!");
    }
}
