package com.johnteacher.quickstart;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

// spring automatically considers this class a spring bean.
// @Component
// @Service // extends the component, includes other annotations as well
// @Repository // also extends component and uses the annotation inside it
public class MyFirstClass {

    private String myVar;

    public MyFirstClass(String myVar) {
        this.myVar = myVar;
    }

    public String sayHello() {
        return "Hello From My First Class ==> myVar = " + myVar;
    }

}
