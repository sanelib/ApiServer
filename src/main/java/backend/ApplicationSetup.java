package backend;

import backend.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class ApplicationSetup implements CommandLineRunner {

    // Simple example shows how a command line spring application can execute an
    // injected bean service. Also demonstrates how you can use @Value to inject
    // command line args ('--name=whatever') or application properties

    @Autowired
    private ProfileService profileService;

    @Override
    public void run(String... args) {
        System.out.println("Args:" + Arrays.toString(args));
        System.out.println(profileService.getMessage());
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApplicationSetup.class, args);
        System.out.println("CurrentProfile:" + System.getProperty("spring.profiles.active"));
    }
}