package org.sample;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.sample.api.Hello;


public class HelloServiceListener implements ServiceListener {

    private final BundleContext bundleContext;

    public HelloServiceListener(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
    }

    @Override
    public void serviceChanged(ServiceEvent serviceEvent) {

        String[] objectClass = (String[])
                serviceEvent.getServiceReference().getProperty("objectClass");

        if (objectClass[0].contains("org.sample.api.Hello")) {
            switch (serviceEvent.getType()) {
                case ServiceEvent.UNREGISTERING:
                    System.out.println("Service of type : " + objectClass[0] + " is Unregistered");
                    break;
                case ServiceEvent.REGISTERED:
                    System.out.println("Service of type : " + objectClass[0] + " is Registered");
                    ServiceReference reference = serviceEvent.getServiceReference();
                    Hello helloService = (Hello) bundleContext.getService(reference);
                    helloService.sayHello();
                    break;
            }
        }

    }
}
