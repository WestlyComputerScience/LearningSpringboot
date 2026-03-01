package com.johnteacher.quickstart.fundementals;

import com.johnteacher.quickstart.QuickstartApplication;
import org.springframework.boot.SpringApplication;

import java.util.Collections;

public class fakeQuickstartApplication {

    // ctx = "context" for short
    // this way our application will return the context of our application
    // ctz holds all the beans that Spring manages, wires together dependencies, and handles their lifecycle
    // var ctx = SpringApplication.run(QuickstartApplication.class, args);

    // MyFirstClass myFirstClass = new MyFirstClass(); // bad! Let's use dependency injection instead!
    // if Spring can find a bean of type "MyFirstClass", then it returns a singleton (only 1 exists in entire application) instance (injecting any automatic dependencies that bean may have)
    // MyFirstClass myFirstClass = ctx.getBean(MyFirstClass.class); // using dependency injection to get our bean (no manual instantiation of our class)

    // despite the class being named myFirstClass, we can search for the bean name "myBean"
    // If not in annotation parameters, checks for class name (i.e. class name was actually myFirstBeanThing
    // MyFirstClass myFirstClass = ctx.getBean("myBean", MyFirstClass.class); // spring throws exception if it can't find the Bean name
    // System.out.println(myFirstClass.sayHello());

//    var app = new SpringApplication(QuickstartApplication.class); // get spring application
//    app.setDefaultProperties(Collections.singletonMap("spring.profiles.active", "test")); // runs our application in "dev" environment
//    var ctx = app.run(args);
//
//    MyFirstService myFirstService = ctx.getBean(MyFirstService.class);
//    System.out.println(myFirstService.tellAStory());
//    System.out.println(myFirstService.getJavaVersion());
//    System.out.println(myFirstService.getOsName());
//    System.out.println(myFirstService.readProperty());
//    System.out.println(myFirstService.getCustomPropertyFromAnotherFile());
//    System.out.println(myFirstService.getCustomPropertyFromAnotherFile2());
//    System.out.println(myFirstService.getCustomProperty());
//    System.out.println(myFirstService.getCustomPropertyInt());

}
