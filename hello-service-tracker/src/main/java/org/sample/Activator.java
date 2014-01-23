package org.sample;


import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;
import org.sample.api.Hello;

public class Activator implements BundleActivator {
    ServiceTracker serviceTracker;
    BundleContext bundleContext;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("Staring HelloWorldServiceTracker Bundle");
        this.bundleContext = bundleContext;

        serviceTracker = new ServiceTracker(bundleContext, Hello.class.getName(),
                                            createHelloWorldServiceCustomizer());
        serviceTracker.open();

    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Stopping HelloWorldServiceTracker Bundle");
        serviceTracker.close();
    }

    private ServiceTrackerCustomizer createHelloWorldServiceCustomizer() {
        return new ServiceTrackerCustomizer() {
            public Object addingService(ServiceReference reference) {
                Object service = bundleContext.getService(reference);
                System.out.println("HelloService is added");
                ((Hello) service).sayHello();
                return service;
            }

            public void modifiedService(ServiceReference reference,
                                        Object service) {
                // No service property modifications to handle.
            }

            public void removedService(ServiceReference reference,
                                       Object service) {
                System.out.println("HelloService is removed");
            }
        };
    }
}
