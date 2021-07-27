package org.example.manual;


public class App 
{
    public static void main( String[] args )
    {
        // we have no choice of what dependency to inject
      MiniOutlook miniOutlook = new MiniOutlook();
      miniOutlook.processMessage("Hi Hatef", "hatef@abc.com");
    }
}
