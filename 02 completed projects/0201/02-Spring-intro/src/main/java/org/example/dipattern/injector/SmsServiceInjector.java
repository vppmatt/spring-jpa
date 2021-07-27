package org.example.dipattern.injector;

import org.example.dipattern.MiniOutlook;
import org.example.dipattern.service.SmsServiceImpl;

public class SmsServiceInjector implements MessageServiceInjector{
    @Override
    public MiniOutlook getConsumer() {
        MiniOutlook miniOutlook = new MiniOutlook(new SmsServiceImpl());
        return miniOutlook;
    }
}
