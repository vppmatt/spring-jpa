package org.example.dipattern.injector;

import org.example.dipattern.MiniOutlook;
import org.example.dipattern.service.EmailServiceImpl;

public class EmailServiceInjector implements MessageServiceInjector{
    @Override
    public MiniOutlook getConsumer() {
        MiniOutlook miniOutlook = new MiniOutlook(new EmailServiceImpl());
        return miniOutlook;
    }
}
