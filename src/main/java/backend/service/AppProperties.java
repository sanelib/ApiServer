package backend.service;

import backend.ApplicationSetup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@ConfigurationProperties
public class AppProperties {

    private static final Logger LOG = LoggerFactory.getLogger(ApplicationSetup.class);

    private String name;
    private String version;
    private String releaseDate;
    private String locale;
    private String messageBundle;

    private Server server;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getMessageBundle() {
        return messageBundle;
    }

    public void setMessageBundle(String messageBundle) {
        this.messageBundle = messageBundle;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    @Override
    public String toString() {
        return "AppProperties{" +
                "name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", locale='" + locale + '\'' +
                ", messageBundle='" + messageBundle + '\'' +
                ", server=" + server +
                '}';
    }

    public static class Server {
        private String name;
        private Host host;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Host getHost() {
            return host;
        }

        public void setHost(Host host) {
            this.host = host;
        }

        @Override
        public String toString() {
            return "Server{" +
                    "name='" + name + '\'' +
                    ", host=" + host +
                    '}';
        }

        public static class Host{
            private String ip;
            private Integer port;

            public String getIp() {
                return ip;
            }

            public void setIp(String ip) {
                this.ip = ip;
            }

            public Integer getPort() {
                return port;
            }

            public void setPort(Integer port) {
                this.port = port;
            }

            @Override
            public String toString() {
                return "Host{" +
                        "ip='" + ip + '\'' +
                        ", port=" + port +
                        '}';
            }
        }
    }

    @PostConstruct
    public void xxx() {
        LOG.info(this.toString());
    }
}
