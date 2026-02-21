package com.johnteacher.quickstart;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello") // gives us hello world in our browser
    public String helloWorld() {
        return "Hello World! Yessir";
    }

}
// == What is Maven?
// - helps programmers manage their projects and builder their programs
// - helps manage dependencies
// - also helps build and test our projects
// == COMMANDS
// - ./mvnw clean compile
// - Patchy Maven is a command line tool
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