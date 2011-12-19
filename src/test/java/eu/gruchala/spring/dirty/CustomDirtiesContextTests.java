package eu.gruchala.spring.dirty;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertNotSame;
import static junit.framework.Assert.assertTrue;

/**
 * @author lgr
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)//comment to see test failing
public class CustomDirtiesContextTests {
    //create new test context for each new test method (context is removed from testing framework cache ...)
    //can be on method too

    @Configuration
    static class ContextConfiguration {
        // this bean will be injected into the InternalContextTest class
        @Bean
        @Singleton//which is default
        public String getSampleString() {
            //noinspection RedundantStringConstructorCall
            return new String("asd");
        }
    }

    private static final List<String> map = new ArrayList<String>();

    @Autowired
    private String sampleString;

    @Test
    public void testNewSingletonInstanceForEachTest() {
        map.add(sampleString);
    }

    @Test
    public void testNewSingletonInstanceForEachTest2() {
        assertNotSame(map.get(0), sampleString);
        //noinspection StringEquality
        assertTrue(map.get(0) != sampleString);
    }
}
