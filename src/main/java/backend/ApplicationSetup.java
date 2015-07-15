package backend;

import backend.service.AppProperties;
import backend.service.MapDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.Arrays;
import java.util.Locale;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class ApplicationSetup implements CommandLineRunner {

    // Simple example shows how a command line spring application can execute an
    // injected bean service. Also demonstrates how you can use @Value to inject
    // command line args ('--name=whatever') or application properties

    @Autowired
    private AppProperties appProperties;

    @Autowired
    private MapDictionaryService mapDictionaryService;

    @Override
    public void run(String... args) {
        Locale.setDefault(new Locale(appProperties.getLocale()));
        System.out.println("Args:" + Arrays.toString(args));

        System.out.println("=============Config==============");

        System.out.println("name: " + appProperties.getName());
        System.out.println("version: " + appProperties.getVersion());
        System.out.println("releaseDate: " + appProperties.getReleaseDate());
        System.out.println("locale: " + appProperties.getLocale());
        System.out.println("messageBundle: " + appProperties.getMessageBundle());

        System.out.println("==============Database============");

        System.out.println("Database: " + appProperties.getServer().getName());
        System.out.println("Host: " + appProperties.getServer().getHost().getIp() + ":" + appProperties.getServer().getHost().getPort());

    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApplicationSetup.class, args);
    }
}