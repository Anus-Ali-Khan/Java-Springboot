package com.anuscode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@SpringBootApplication // Below mention annotations were used in spring now //@SpringBootApplication  is used instead of these three
//@ComponentScan(basePackages =  "com.amigoscode") // It is used to search for specified package in our file
//@EnableAutoConfiguration
//@Configuration
@RestController // indicates that this class has rest-endpoints and it also indicates that all the classes are controller and their methods will return JSON response
// Spring-Web-MVC -- it serves as servlet(Process which handles HTTP requests)

@RequestMapping("api/v1/customers")
public class Main {

    // For connecting to db
    private final CustomerRepository customerRepository; // variable declaration

    public Main(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
      SpringApplication.run(Main.class, args);
    }


    // Get Api (get list of customers)
    @GetMapping
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    //Post Api (create new customer)
    record NewCustomerRequest(
            String name,
            String email,
            Integer age
    ){}

    @PostMapping
    public void addCustomer(@RequestBody NewCustomerRequest request){ //@RequestBody will capture the client side request and then convert it into JSON
        Customer customer = new Customer();
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setAge(request.age());
        customerRepository.save(customer);

    }


//    @GetMapping("/greet")       // endpoints that clients can call
////    public String greet(){
////        return "Hello";
////    }
//    public GreetResponse greet() { // it returns JSON response
//         GreetResponse response =  new GreetResponse(
//                                        "Hello",
//                                        List.of("Java","Golang","JavaScript"),
//                                        new Person("Alex",28, 30_000)
//
//        );
//        return response;
//    }
//
//    record Person(String name, int age, double savings){}
//
//    record GreetResponse(
//            String greet,
//            List<String> favProgrammingLanguages,
//            Person person
//            ) {}

    //'Record' is a keyword introduced in Java 14 that helps you create simple, immutable data carrier classes without boilerplate code.
    // Instantiated with the syntax, record className(dataType x, dataType y) {} It's a quick and efficient way to encapsulate a group of related data.
    // ** Classes are mutable while records are immutable
    // Record creates following:
    // 1) encapsulate variable
    // 2) Constructor
    // 3) getter and setter
    // 4) toString method
    // 5) equals and hashcode method

    // We can write below code instead of record
    // ** The JSON response that we are getting is due to the external library called Jackson
//    class GreetResponse{
//        private final String greet;
//
//        GreetResponse(String greet){
//            this.greet = greet;
//        }
//
//        public String getGreet(){
//            return greet;
//        }
//
//        @Override
//        public String toString() {
//            return "GreetResponse{" +
//                    "greet='" + greet + '\'' +
//                    '}';
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            GreetResponse that = (GreetResponse) o;
//            return Objects.equals(greet, that.greet);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hashCode(greet);
//        }
//    }
}
