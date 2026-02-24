package com.johnteacher.quickstart;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    //  @GetMapping(path = "/hello") // gives us hello world in our browser
    // public String helloWorld() {
    //    return "Hello World! Yessir";
    //}

}
// == What is Maven?
// - helps programmers manage their projects and builder their programs
// - helps manage dependencies
// - also helps build and test our projects
// == COMMANDS
// - ./mvnw clean compile
// - Apache Maven is a command line tool
// - general layout is
// - - mvnw [options] [<goal(s)>] [<phase(s)>]
// - Maven has 3 phases (think of it as a lifecycle, order of goals):
// - - clean (remove temporary directories and files)
// - - default (where the most useful goals live)
// - - site (where documentation is generated)
// - more on the clean phase:
// - - pre-clean (hook before cleaning) (aka you build a plugin and want to hook into the time before or after the clean
// - - clean (does the actual cleaning)
// - - post-clean (hook for after cleaning)
// == PROJECT STRUCTURE
// - target directory is where maven puts all it's processed stuff
// - - aka if you call clean the target directory is deleted
// == BACK TO COMMANDS
// - below is an order of the maven default phase (if want to run everything up to verify, then type verify
// - - 1.) compile (compiles your code into bytecode)
// - - 2.) test (runs unit tests)
// - - 3.) package (creates a jar or war file in target)
// - - 4.) verify (runs checks & integration tests)
// == PROJECT STRUCTURE
// - java folder fo java files
// - src/resources for our application property config file (if any static files to use/load in, then put it in src/main/resources
// - src/test is usually a reflection of our src main java and equivalent test class for it
// - can also have a src/test/resources have static and config files used only in the test (override config in tests from src files)
// - target has all our compiled code
// - must follow this project structure for Maven!
// == INFO
// - he says he doesn't follow Test Driven Development (tests before code)
// - he calls ./mvnw clean test to always test his code (also compiling is quick and no want leftover files from previous code, likelyhood is low though)
// - once done, he likes to build the artifact (JAR file)
// - - ./mvnw clean package (or verify)
// - - - then did "cd target" to go to target directory
// - - - - java -jar <copy_jar_file_path>.jar
// - - - then right before he commits the code, he'll run one last maven clean and call
// - - - - ./mvnw clean verify (to make sure all is good)
// == RUN PROJECT LOCALLY
// - many ways
// - he wants to run application via command line via maven via springboot maven plugin
// - - ./mvnw spring-boot:run (CRTL + C to cancel)
// - springboot is a framework for building Java applications
// - - framework is a bunch of libraries written on top of a language's core library to solve common problems
// - - - i.e. connected to database or exposing a RestAPI to different parts of a system
// - - - spring framework helps us accomplish this
// == SPRING FRAMEWORK
// - This is the order of things built (top to bottom)
// - - Your App
// - - Spring Boot (additional functionality, reduces configuration for me by conventions, which are well documented)
// - - Spring Framework (used by itself, highly configurable, takes a lot of effort from me)
// - - Language's Core Library
// == SPRING APP LAYERS (each solves a specific problems) (every spring framework/application can be thought about in these layers)
// - Presentation
// - - take all the data from service layer and expose them to the user (i.e. RestAPI with controllers etc.)
// - Service
// - - use what we got from our persistence layer to meet the requirements that our application is being built to handle
// - - We don't want our presentation layer talking with our persistence layer
// - Persistence
// - - handles interaction with (persistence technology) the database (entities - represent domain and map to tables etc.)
// - - - Use entities to interact with database with respository pattern or DAOs (Data Access Objects)
// - - - - type of functionality exposed by repositories and DAOs, would be CRUD (create read update delete) (if you need anything more, can build it into our DAOs/repositories)
// - - expose this to good interfaces, allow you to change it and application adapts to it
// == INVERSION OF CONTROL
// - instead of classes inside classes, do interfaces inside classes and let the spring framework to inject the concrete classes (that way if you change something, it updates on it's own)
// - dependency injection
// == SUMMARY
// - we know that we program with interfaces instead of concrete classes and leave the framework to supply the concrete classes via dependency injection for us
// - beans = the concrete classes from dependency injection

// Decided to switch guides
// == CORE FEATURES
// IOC - inversion control container
// - manages lifecycle of a java object
// AOP - aspect oriented programming
// DAF - data access framework
// MVC - Spring MVC Framework
// == SPRING BEAN
// - An object that's managed by the Spring Framework in a java application
// - aims to simplify application development
// - can be configured using XML, Java annotations, or Java code
// == LIFE CYCLE OF A SPRING BEAN
// - means when/how it's born, and how it behaves in life and dies
// - bean lifecycle is managed by the spring container
// == CONFIGURE A BEAN
// @Configuration declares a class as a "full" configuration class (class must be non-final and public)
// @Bean declares bean configuration inside a configuration class
// - method must be "non-final" and "non-private" (i.e. public, protected, or packaged-private)
// EX:
// @Configuration
// public class AppConfig {
//  @Bean
//  public PaymentService paymentService(AccountRepository accountRepository) {
//      return new PaymentServiceImpl(accountRepository); // account repository as a dependency for the payment service implementation
//     }
//  }
//  @Bean
//  public AccountRepository accountRepository() {
//      return new JdbcAccountRepository(dataSource());
//  }
//  @Bean
//  public DataSource dataSource() {
//      return (...)
//  }
// == SPRING COMPONENT SAMPLE
// - spring component contains class-level annotation that marks a class as a Spring Component (@Component)
// - constructor-dependency injection is automatically done using @Autowired by injecting the constructor parameter(s)
// - @Autowired on Constructor is optional if there is only one constructor
// EX:
// @Component
// public class PaymentServiceImpl {
//      private final AccountRepository accountRepository;
    //  @Autowired
    //  public PaymentServiceImpl(AccountRepository accountRepository) {
    //          this.accountRepository = accountRepository;
    //     }
    //  }
// == SPRING COMPONENTS
// - Spring provides component stereotype to classify classes as Spring Components
// - - sub-types are available as refinement for the standard components
// - @Component as a general component annotation indicating that the class should be initialized, configured, and managed by the core container
// - @Repository, @Service, and @Controller as a meta-annotation for @Component that allows for further re-fine components
// - Own Stereotype annotations can (and should) be defined to support general architecture principles
// EX:
//  @Bean("ds") // if we don't give it a name, spring will name it ds (if didn't indicate this, it would be called dataSource)
//  public DataSource dataSource() {
//      return (...)
//  }
// == DEPENDENCY INJECTION
// different ways to use dependency injection
// - 1.) constructor injection
// - 2.) field injection
// - 3.) configuration methods
// - 4.) setter method injection (only 1 parameter)
// == Constructor Injection
// EX:
/*
@Service
public class DefaultPaymentService {
    private final AccountRepository accountRepository;

    public DefaultPaymentService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
}

Another

@Repository
public class JdbcAccountRepository implements AccountRepository {
    private final DataSource dataSource

    public JdbcAccountRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}

Another (Qualifier specifies which bean to inject)

@Configuration
public class ApplicationConfig {

    @Bean
    @Qualifier("primary")
    public AccountRepository primary() {
        return new JdbcAccountRepository(...);
    }

    @Bean
    @Qualifier("secondary")
    public AccountRepository secondary() {
        return new JdbcAccountRepository(...);
    }
}

Then on the service level, we can...

@Service
public class DefaultPaymentService {
    @Autowired
    public DefaultPaymentService(@Qualifier("primary") AccountRepository accountRepository) { // specify to use primary bean
        this.accountRepository = accountRepository;
    }
}

We can also use the @Primary annotation

@Configuration
public class ApplicationConfig {

    @Bean
    @Primary
    public AccountRepository primary() {
        return new JdbcAccountRepository(...);
    }

    @Bean
    public AccountRepository secondary() {
        return new JdbcAccountRepository(...);
    }
}

then it automatically gets injected by constructor with no specifications

@Service
public class DefaultPaymentService {
    @Autowired
    public DefaultPaymentService(AccountRepository accountRepository) { // specify to use primary bean
        this.accountRepository = accountRepository;
    }
}

// ===== FIELD INJECTION
// - allows direct injection into field declaration without constructor or method delegation (discourage, testing is very complex, only used in test classes)

@Service
public class DefaultPaymentService {
    @Autowired
    private AccountRepository accountRepository;
}

// ===== METHOD INJECTION
 - allows setting one or many dependencies by one method
 - allows for init work if needed while receiving dependencies

@Service
public class DefaultPaymentService {
    @Autowired
    public void configureClass(AccountRepository accountRepository, FeeCalculator feeCalculator) {
        //...
    }
}

// ===== SETTER INJECTION

@Service
public class DefaultPaymentService {
    @Autowired
    public void setAccountRepository(AccountRepository accountRepository) { // spring reads this as a setter injection
        //...
    }
}

- good rule of thumb to use constructors for mandatory dependencies and setter/configuration methods for optional dependencies

// ===== BEAN SCOPE
 - Bean availability and which other beans it can interact with
 - spring provides multiple scopes
 - "singleton" is the default scope of the bean
 - scope types:
 - - singleton (default, all requests will recieve same bean)
 - - prototype (new instance of bean each time bean is requested, good for beans specific to user)
 - - request (only valid in context of web-aware spring application context for a single each http request, new bean created with each http request)
 - - session (scope is valid on web-aware spring app from http session (NOT REQUEST))
 - - application (scope is valid in web-aware spring app, scoped at application level)
 - - websocket (valid in web-area spring app, scoped at websocket level)
 - important for managing beans
 - EX:

 @Configuration
 public class MyConfig {
    @Bean
    @Scope("prototype") // give our own name
    public Bean1 bean1() { //... }

    @Bean
    @SessionScope // avoids typos/mistakes more since built-in
    public Bean2 bean2() { //... }
 }

 ===== SPECIAL SPRING BEANS
 - Environment
 - - environment abstraction
 - - lets you change your applications config depending on where it's running - without changing code
 - - can also be injected into code

    @Configuration
    public class ApplicationConfig {
        @Autowired final Environment environment;
        @Bean
        public PaymentService paymentService() {
            var profile = Profiles.of("cloud");
            var isOkay = this.environment.acceptsProfiles(profile);
            this.environment.getProperty("data.driver");
            return ...
        }
    }

====== BEAN PROFILES

// Spring Component
@Service
@Profile("cloud") // only available on the profile "cloud"
public class DefaultPaymentService implements PaymentService{}

====== VALUE ANNOTATION
 - helps inject certain properties (i.e. this URL)
@Value ("${jdbc.url}")
private string url;

 - or

 @Value("#{systemProperties['user.region']}")
 public void setDefaultLocale(String defaultLocale) {
    this.defaultLocale = defaultLocal;
}

====== GOOD PRACTICES FOR SPRING FRAMEWORK ....

=== SPLIT CONFIGURATION
 - splits classes based on architecture
 - classes can import each other

=== SPRING BOOT?
 - an approach to develop spring-based applications with minimal or no configurations
 - provides a set of starter build files
 - comes with a lot of auto-configuration, auto-configures required classes
 - why?
 - comes with standalone applications
 - embeded servers (no need to deploy WAR files)
 - starters
 - autoconfiguration
 - production-ready feature
 - no xml configuration

 - metadata for project
 - group (for the group id of the company, i.e. meta)
 - artifact (for the subcompany, i.e. instagram/facebook)
 - JAR = java archive
 - WAR = web archive
 - SDK = software development kit

====== PROJECT STRUCTURE
 - static in src/resources folder (if we want static files like HTML files or build UI for restAPI
 - application.properties in src/resources has file extension properties

// Note: the banner.txt in resources lets a person know what service they're starting

 */