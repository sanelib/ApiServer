package backend;

import backend.service.AppProperties;
import backend.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class ApplicationSetup implements CommandLineRunner {

    // Simple example shows how a command line spring application can execute an
    // injected bean service. Also demonstrates how you can use @Value to inject
    // command line args ('--name=whatever') or application properties

    @Autowired
    private ProfileService profileService;

    @Autowired
    private AppProperties appProperties;

    @Override
    public void run(String... args) {
        System.out.println("Args:" + Arrays.toString(args));
        System.out.println(profileService.getToString());
        System.out.println(appProperties.toString());
        System.out.println("Getting locale:" + appProperties.getLocale());
        Locale.setDefault(new Locale(appProperties.getLocale()));

    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApplicationSetup.class, args);
    }
}