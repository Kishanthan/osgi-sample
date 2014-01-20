package org.sample;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;


public class HelloServiceListener implements ServiceListener {

    @Override
    public void serviceChanged(ServiceEvent serviceEvent) {

        String[] objectClass = (String[])
                serviceEvent.getServiceReference().getProperty("objectClass");

        if (objectClass[0].contains("org.sample.api.Hello")) {
            switch(serviceEvent.getType()){
                case ServiceEvent.UNREGISTERING:
                    System.out.println("Service of type : " +objectClass[0]+ " is Unregistered");
                    break;
                case ServiceEvent.REGISTERED:
                    System.out.println("Service of type : " +objectClass[0]+ " is Registered");
                    break;
                case ServiceEvent.MODIFIED:
                    System.out.println("Service of type : " +objectClass[0]+ " is Modified");
                    break;
            }
        }

    }
}
