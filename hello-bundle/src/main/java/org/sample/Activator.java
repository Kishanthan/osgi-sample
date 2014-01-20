package org.sample;


import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.sample.api.Hello;

public class Activator implements BundleActivator {

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("Staring HelloWorld Bundle");

        ServiceReference reference = bundleContext.getServiceReference(Hello.class.getName());

        Hello helloService = null;

        if (reference != null) {
            helloService = (Hello) bundleContext.getService(reference);
        }

        if (helloService != null) {
            helloService.sayHello();
        }
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Stopping HelloWorldBundle");
    }
}
