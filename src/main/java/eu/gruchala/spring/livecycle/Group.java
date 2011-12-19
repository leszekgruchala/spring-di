package eu.gruchala.spring.livecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * </p>
 *
 * @author lgr
 */
//Registered in AppConfig.class
public class Group {
    public boolean isOk() {
        return true;
    }

    @PostConstruct
    private void doSomethingJustAfterInitialisation() {
        System.out.println("PostConstruct invocation.");
    }

    @PreDestroy
    private void doSomethingJustBeforeObjectDestroy() {
        System.out.println("PreDestroy invocation.");
    }
}
