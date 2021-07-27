package org.example.dipattern.injector;

import org.example.dipattern.MiniOutlook;

public interface MessageServiceInjector {
    /*
    * This interface has only one method that we can invoke
    * whenever we need a bean that cosumes it.
    *
    * */

    public MiniOutlook getConsumer();
}
