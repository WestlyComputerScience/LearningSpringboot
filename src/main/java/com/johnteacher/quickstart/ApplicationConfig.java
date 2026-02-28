package com.johnteacher.quickstart;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration // Let's spring know to scan this class upon startup
public class ApplicationConfig {

    // if no @Bean, then we get a no such bean exception. Instead, we could mark our class as @Component to not need @bean.
    // Bean("myBean")
    @Bean
    @Qualifier("Bean1")
    // @Profile("dev") // cannot be used in test profile, gives error
    @Primary // gives higher priority to this bean if qualifier not specified
    public MyFirstClass myFirstBean() {
        return new MyFirstClass("First Bean");
    }

    @Bean
    @Qualifier("bean2") // bean won't be called bean1/bean2, but it will have this extra qualifier
    public MyFirstClass mySecondBean() {
        return new MyFirstClass("Second Bean");
    }

    @Bean
    @Qualifier("bean3")
    @Profile("dev") // this bean is only available in the DEV environment
    public MyFirstClass myThirdBean() {
        return new MyFirstClass("Third Bean");
    }

    @Bean
    @Qualifier("bean4")
    @Profile("test") // this bean is only available in the TEST environment
    public MyFirstClass myFourthBean() {
        return new MyFirstClass("Fourth Bean");
    }

}
