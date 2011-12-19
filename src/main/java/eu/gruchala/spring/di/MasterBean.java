package eu.gruchala.spring.di;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

/**
 * <p/>
 *
 * @author lgr
 */
@Service
@DependsOn("dependant")
public class MasterBean {

    public MasterBean() {
        System.out.println("I'VE TO RELY ON MY DEPENDANT!");
    }
}
