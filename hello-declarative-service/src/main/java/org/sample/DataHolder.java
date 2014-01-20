package org.sample;


import org.sample.api.Hello;

public class DataHolder {
    private  static DataHolder instance = new DataHolder();
    private Hello helloService;

    public  static DataHolder getInstance() {
        return instance;
    }

    public void setHelloService(Hello helloService) {
        this.helloService = helloService;
    }

    public Hello getHelloService() {
        return helloService;
    }
}
