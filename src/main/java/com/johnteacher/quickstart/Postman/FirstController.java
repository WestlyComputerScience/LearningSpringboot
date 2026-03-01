package com.johnteacher.quickstart.Postman;

import org.springframework.web.bind.annotation.*;

/*
Note: @Controller is used for traditional spring applications to return HTML pages
 - @RestController is used for REST APIs. It automatically adds @Controller and @ResponseBody to every method. It returns data, not views.
 */

// http://localhost:8080/       to access the controllers content

//@RestController // you need the spring web dependency for this
// Spring detects this class and creates beans of them in the application context
// when the application starts up, Spring creates a mapping between the URL (http methods) and the corresponding controller methods
// a bigger controller decides which method should hangle the request (Handler Mapping)
// - the handler mapping consults the mapping registry to find the dedicated controller
// - - then this controller has the services included in it etc.
public class FirstController {
//
//    // Get requests are meant to retrieve a web source, aka a view of your website
//    // the hello parts requires http://localhost:8080/hello instead of http://localhost:8080/
////    @GetMapping("/hello") // inside this rest controller, it signals we have a get method
////    public String hello() {
////        return "Hello from my first controller";
////    }
//
////    @GetMapping("/hello-2")
////    // in inspect -> Network, then click hello-2 to see our Response Code in "Headers"
////    @ResponseStatus(HttpStatus.ACCEPTED) // has HttpStatus with an enum of a bunch of response codes
////    public String sayHello2() {
////        return "Hello from my first controller";
////    }
//
//    // post is where we want to send data to the client/server to create/update resource (post data is sent in body of HTTP request, not in the URL)
//    // expects a string msg as a body
//    // hhmmmm, lol, you can put a breakpoint here, send a post in Postman, then check it here. Lmao.
////    @PostMapping("/post")
////    // @RequestBody to bind the RequestBody with the method parameter.
////    // we can make it a complex JSON object in Postman to accept multiple parameters
////    public String post(@RequestBody String msg) {
////        return "Request accepted and message is: " + msg;
////    }
//
//    // tells Spring this method should handle an HTTP request of the specified type
//    @PostMapping("/post-order")
//    public String post(@RequestBody Order order) {
//        return "Request accepted and order is: " + order.toString();
//    }
//
//    @PostMapping("/post-order-record")
//    public String postRecord(@RequestBody OrderRecord order) {
//        return "Request accepted and order is: " + order.toString();
//    }
//
////    // want: http://localhost:8080/hello/John
////    @GetMapping("/hello/{userName}") // if same name as method variable, then Spring automatically refers this variable to the method variable
////    public String pathVar(String userName) { // to pass a variable in my path, tell Spring in the @GetMapping with /{var}
////        return "My value = " + ;
////    }
//
//    // This is what he would prefer
//    // even with spaces works
//    // i.e. http://localhost:8080/hello/wes duisah
//    // this is refered to as a path variable, use when you want the value is actually part of the URI
//    @GetMapping("/hello/{user-name}")
//    public String pathVar(@PathVariable("user-name") String userName) { // tells Spring that this parameter is the same as the one specified in path
//        return "My value = " + userName;
//    }
//
//    // want: http://localhost:8080/hello?param_name=paramvalue&param_name2=value_2
//    // @RequestParam shows it's a query parameter, used when value is passed as a query parameter
//    @GetMapping("/hello")
//    // even if the method names are different, the @GetMapping gives Spring and ambiguity error
//    public String paramVar(@RequestParam("user-name") String userName, @RequestParam("last-name") String lastName) {
//        return "My value = " + userName + " " + lastName;
//    }

}
