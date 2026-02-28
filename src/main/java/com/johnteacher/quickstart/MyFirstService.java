package com.johnteacher.quickstart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

// contains business logic
// implements business rules, coordinates repositories, handles transactions
@Service
@PropertySources({
        @PropertySource("classpath:custom.properties"),
        @PropertySource("classpath:custom-file-2.properties")
}) // allows us to read from our custom properties file we made
public class MyFirstService {

    // === CONSTRUCTOR INJECTION (BEST WAY) ===
//    private final MyFirstClass myFirstClass; // "final" makes sure it cannot be modified

    // don't need the autowired keyword since spring will try to inject anything that's injectable upon application start
    // @Autowired // spring is told to find a bean of this type and inject it here automatically
//    public MyFirstService(@Qualifier("bean2") MyFirstClass myFirstClass) { // if multiple beans of same class, need a qualifier
//        this.myFirstClass = myFirstClass;
//    }

    // === FIELD INJECTION ===
//    @Autowired
//    @Qualifier("mySecondBean") // tries to look up the qualifer bean name, or simply the method/bean name
//    private MyFirstClass myFirstClass; // this also works, but spring doesn't recommend this

    // === METHOD INJECTION ===
//    private MyFirstClass myFirstClass;
//    @Autowired // tells spring to inject here
//    public void injectDependencies(@Qualifier("bean2") MyFirstClass myFirstClass) {
//        this.myFirstClass = myFirstClass;
//    }

    // === SETTER INJECTION ===
//    private MyFirstClass myFirstClass;
//
//    @Autowired
//    public void setMyFirstClass(@Qualifier("Bean1") MyFirstClass myFirstClass) {
//        this.myFirstClass = myFirstClass;
//    }

    private final Environment environment; // gets system information
    private final MyFirstClass myFirstClass;

    @Autowired
    public MyFirstService(Environment environment, MyFirstClass myFirstClass) {
        this.environment = environment;
        this.myFirstClass = myFirstClass;
    }

    public String tellAStory() {
        return "the dependency is saying : " + myFirstClass.sayHello();
    }

    public String getJavaVersion() {
        return environment.getProperty("java.version");
    }

    public String getOsName() {
        return environment.getProperty("os.name");
    }

    public String readProperty() {
        return environment.getProperty("my.custom.property"); // gets a custom property from our YAML file (similar to JSON, based on indentation and not {})
    }



    // === getting custom properties (from resources folder) ===

    @Value("${my.prop}") // get this value from the custom properties file
    private String customPropertyFromAnotherFile;

    @Value("${my.prop.2}") // get this value from the custom properties file
    private String customPropertyFromAnotherFile2;

    public String getCustomPropertyFromAnotherFile() {
        return customPropertyFromAnotherFile;
    }

    public String getCustomPropertyFromAnotherFile2() {
        return customPropertyFromAnotherFile2;
    }

    @Value("${my.custom.property}") // if spring sees this value, it will try to read this property from the YAML file
    private String customProperty;

    public String getCustomProperty() {
        return customProperty;
    }

    @Value("${my.custom.property.int}") // if spring sees this value, it will try to read this property from the YAML file
    private Integer customPropertyInt;

    public Integer getCustomPropertyInt() {
        return customPropertyInt;
    }

    // === SPRING PROFILES ===
    // allows testing in dev environments, basically, hover over QuickStartApplication in the top right
    // next, click edit configurations, then set active profile to dev. Anything in resources with
    // -dev tag will replace anything normal.
    // i.e. application.properties loads, then spring sees application-dev.properties
    // it will then overwrite application.properties with application-dev.properties

}
