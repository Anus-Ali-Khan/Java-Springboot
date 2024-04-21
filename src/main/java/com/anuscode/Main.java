package com.anuscode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@SpringBootApplication // Below mention annotations were used in spring now //@SpringBootApplication  is used instead of these three
//@ComponentScan(basePackages =  "com.amigoscode") // It is used to search for specified package in our file
//@EnableAutoConfiguration
//@Configuration
@RestController // indicates that this class has rest-endpoints and it also indicates that all the classes are controller and their methods will return JSON response
// Spring-Web-MVC -- it serves as servlet(Process which handles HTTP requests)
public class Main {
    public static void main(String[] args) {
      SpringApplication.run(Main.class, args);
    }

    @GetMapping("/greet")       // endpoints that clients can call
//    public String greet(){
//        return "Hello";
//    }
    public GreetResponse greet(){
        return new GreetResponse("Hello"); // it returns JSON response
    }
    // record GreetResponse(String greet){}
    //'Record' is a keyword introduced in Java 14 that helps you create simple, immutable data carrier classes without boilerplate code.
    // Instantiated with the syntax, record className(dataType x, dataType y) {} It's a quick and efficient way to encapsulate a group of related data.
    // Classes are mutable while records are immutable

    // We can write below code instead of record
    class GreetResponse{
        private final String greet;

        GreetResponse(String greet){
            this.greet = greet;
        }

        public String getGreet(){
            return greet;
        }

        @Override
        public String toString() {
            return "GreetResponse{" +
                    "greet='" + greet + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GreetResponse that = (GreetResponse) o;
            return Objects.equals(greet, that.greet);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(greet);
        }
    }
}
