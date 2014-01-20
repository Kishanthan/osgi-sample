package org.sample;


import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.sample.api.Hello;

public class Activator implements BundleActivator {

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("Staring HelloWorldServiceTracker Bundle");

        ServiceTracker serviceTracker = new ServiceTracker(bundleContext,
                                                           Hello.class.getName(),null);
        serviceTracker.open();

        Object[] services = serviceTracker.getServices();

        if (services != null) {
            for (Object service : services) {
                ((Hello) service).sayHello();
            }
        }

        serviceTracker.close();
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Stopping HelloWorldServiceTracker Bundle");
    }
}
