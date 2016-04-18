package net.oktaz.booty.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * https://spring.io/guides/gs/accessing-data-mongodb/
 */
@RestController
@EnableAutoConfiguration
public class ExampleController {

    @Autowired
    private CustomerRepository repository;

    @RequestMapping("/")
    String home() {
        return "Hello, Jerks";
    }

    @RequestMapping("/customer")
    String customer() {

        StringBuilder builder = new StringBuilder();
        repository.deleteAll();

        // save a couple of customers
        repository.save(new Customer("Alice", "Smith"));
        repository.save(new Customer("Bob", "Smith"));

        // fetch all customers
        builder.append("Customers found with findAll():\n");
        builder.append("-------------------------------\n");


        for (Customer customer : repository.findAll()) {
            builder.append(customer +  "\n");
        }
        builder.append("\n");

        // fetch an individual customer
        builder.append("Customer found with findByFirstName('Alice'):\n");
        builder.append("--------------------------------\n");
        builder.append(repository.findByFirstName("Alice") + "\n");

        builder.append("Customers found with findByLastName('Smith'):");
        builder.append("--------------------------------\n");

        for (Customer customer : repository.findByLastName("Smith")) {
            builder.append(customer + "\n");
        }

        return builder.toString();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ExampleController.class, args);
    }
}
