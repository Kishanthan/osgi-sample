package org.sample.impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.sample.api.Hello;


public class Activator implements BundleActivator {
    ServiceRegistration registration;
    @Override
    public void start(BundleContext bundleContext) throws Exception {
        HelloWorld helloWorld = new HelloWorld();
        registration = bundleContext.registerService(Hello.class, helloWorld, null);
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        registration.unregister();
    }
}
