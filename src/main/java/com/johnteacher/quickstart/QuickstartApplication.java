package com.johnteacher.quickstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class QuickstartApplication {

    public static void main(String[] args) {
        // ctx = "context" for short
        // this way our application will return the context of our application
        // ctz holds all the beans that Spring manages, wires together dependencies, and handles their lifecycle
        var ctx = SpringApplication.run(QuickstartApplication.class, args);

        // MyFirstClass myFirstClass = new MyFirstClass(); // bad! Let's use dependency injection instead!
        // if Spring can find a bean of type "MyFirstClass", then it returns a singleton (only 1 exists in entire application) instance (injecting any automatic dependencies that bean may have)
        MyFirstClass myFirstClass = ctx.getBean(MyFirstClass.class); // using dependency injection to get our bean (no manual instantiation of our class)
        System.out.println(myFirstClass.sayHello());
    }

    @Bean
    public MyFirstClass myFirstClass() {
        return new MyFirstClass();
    }

}
