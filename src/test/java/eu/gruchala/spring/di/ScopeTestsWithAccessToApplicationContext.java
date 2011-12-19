package eu.gruchala.spring.di;

import eu.gruchala.spring.TestConfig;
import eu.gruchala.spring.livecycle.Group;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.inject.Named;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * @author lgr
 */
@ContextConfiguration(classes = {TestConfig.class})
public class ScopeTestsWithAccessToApplicationContext extends AbstractJUnit4SpringContextTests {

    @Autowired
    private Participant participant;

    @Autowired
//    @Qualifier("workerBean") //works too
    @Named("workerBean")
    private Participant worker;

    @Autowired
    private Group group;

    @Autowired
    private NamedTaggedBean namedTaggedBean;

    /**
     * Interface Participant is marked as @Scope(BeanDefinition.SCOPE_SINGLETON)
     */
    @Test
    public void testScopeSingleton() {
        final Participant studentBean = (Participant) applicationContext.getBean("student");
        final Participant studentBean2 = (Participant) applicationContext.getBean("student");

        assertTrue(studentBean == studentBean2);
        assertEquals(studentBean, studentBean2);
    }

    /**
     * Bean's name is Worker, but has changed name through @Service(value = "workerBean")
     */
    @Test
    public void testScopePrototype() {
        final Participant workerBean = (Participant) applicationContext.getBean("workerBean");
        final Participant workerBean2 = (Participant) applicationContext.getBean("workerBean");

        assertTrue(workerBean != workerBean2);
    }

    /**
     * Worker bean has @Primary annotation thus has precedence if there are many implementations
     * of the same interface
     */
    @Test
    public void testGetDefaultImplementationWithoutQualifierAnnotation() {
        assertTrue(participant instanceof Worker);
        assertTrue(worker instanceof Worker);
    }

    @Test
    public void testLazyInitialisation() {
//      In console:  Pre-instantiating singletons... misleading, but not yet initialised
        //Can I somehow check if lazyDeveloper is in memory already?
        System.out.println("No lazy developer yet.");
        applicationContext.getBean("lazyDeveloper");
    }

    @Test
    public void testGroupInitializedFromImportedConfigurationClass() {
        //We rely on TestConfig, which imports AppConfig which has group bean definition
        assertTrue(group.isOk());
    }

    @Test
    public void testNamedTaggedBeanCanBeMarkedTooAsBean() {
        assertTrue(namedTaggedBean.working());
    }

    @Test
    public void testDependsOnUsage() {
        applicationContext.getBean("masterBean");
    }
}
