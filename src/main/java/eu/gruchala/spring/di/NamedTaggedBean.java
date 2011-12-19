package eu.gruchala.spring.di;

import javax.inject.Named;

/**
 * <p/>
 *
 * @author lgr
 */
@Named
public class NamedTaggedBean {

    public boolean working() {
        return true;
    }
}
