package backend.service;

import backend.ApplicationSetup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Configuration
@ConfigurationProperties
public class AppProperties {

    private static final Logger LOG = LoggerFactory.getLogger(ApplicationSetup.class);

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    private Server server;

    public Server getServer() {
        return server;
    }

    public void setServer(Server server){
        this.server = server;
    }

    private String locale;

    public String getLocale(){
        return this.locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public static class Server {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name){
            this.name = name;
        }

        @Override
        public String toString() {
            return "Server{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "AppProperties{" +
                "name='" + name + '\'' +
                ", server=" + server +
                '}';
    }

    @PostConstruct
    public void xxx() {
        LOG.info(this.toString());
    }
}
