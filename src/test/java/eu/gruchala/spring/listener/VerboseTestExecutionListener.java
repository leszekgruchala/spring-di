package eu.gruchala.spring.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

/**
 * @author lgr
 */
public class VerboseTestExecutionListener implements TestExecutionListener {

    final static Logger L = LoggerFactory.getLogger(VerboseTestExecutionListener.class);

    @Override
    public void beforeTestClass(TestContext testContext) throws Exception {

        L.info(String.format("Just BEFORE making the test on CLASS: %s", testContext.getTestClass()));
    }

    @Override
    public void prepareTestInstance(TestContext testContext) throws Exception {
        L.info(String.format("I'm PREPARING the entire test for INSTANCE: %s", testContext.getTestInstance()));
    }

    @Override
    public void beforeTestMethod(TestContext testContext) throws Exception {
        L.info(String.format("Just BEFORE making the separated test for METHOD: %s", testContext.getTestMethod()));
    }

    @Override
    public void afterTestMethod(TestContext testContext) throws Exception {
        L.info(String.format("Just AFTER making the separated test for METHOD: %s", testContext.getTestMethod()));
    }

    @Override
    public void afterTestClass(TestContext testContext) throws Exception {
        L.info(String.format("Just AFTER making the entire test for CLASS: %s", testContext.getTestClass()));
    }
}
