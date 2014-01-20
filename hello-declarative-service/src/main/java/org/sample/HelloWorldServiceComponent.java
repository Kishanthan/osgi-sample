package org.sample;

import org.osgi.service.component.ComponentContext;
import org.sample.api.Hello;

/**
 * The Declarative Service Component for Hello Service
 *
 * @scr.component name="org.sample.HelloWorldServiceComponent"
 * immediate="true"
 * @scr.reference name="org.sample.hello"
 * interface="org.sample.api.Hello"
 * cardinality="1..1"
 * policy="dynamic"
 * bind="setHelloService"
 * unbind="unsetHelloService"
 */
public class HelloWorldServiceComponent {


    protected void activate(ComponentContext ctxt) {
        System.out.println("HelloWorldServiceComponent is Activated");
        Hello helloService = DataHolder.getInstance().getHelloService();
        helloService.sayHello();
    }

    protected void deactivate(ComponentContext ctxt) {
        System.out.println("HelloWorldServiceComponent is Deactivated");
    }

    protected void setHelloService(Hello helloService) {
        System.out.println("Acquiring HelloService");
        DataHolder.getInstance().setHelloService(helloService);
    }

    protected void unsetHelloService(Hello hello) {
        System.out.println("Releasing HelloService");
        DataHolder.getInstance().setHelloService(null);
    }

}
