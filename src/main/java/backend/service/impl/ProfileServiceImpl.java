package backend.service.impl;

import backend.ApplicationSetup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import backend.service.ProfileService;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class ProfileServiceImpl implements ProfileService {

    private static final Logger LOG = LoggerFactory.getLogger(ApplicationSetup.class);


    @Value("${name}")
     String name;

    @Value("${version}")
    String version;

    @Value("${releaseDate}")
    String releaseDate;

    @Value("${locale}")
    String locale;

    @Value("${messageBundle}")
    String messageBundle;

    @Value("${server.name}")
     String serverName;

    @Value("${server.host.ip}")
     String serverHostIP;

    @Value("${server.host.port}")
    private int serverHostPort;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public String getReleaseDate() {
        return releaseDate;
    }

    @Override
    public String getLocale() {
        return locale;
    }

    @Override
    public String getMessageBundle() {
        return messageBundle;
    }


    public String getServerName() {
        return serverName;
    }

    public String getServerHostIP() {
        return serverHostIP;
    }

    public int getServerHostPort() {
        return serverHostPort;
    }

    @Override
    public String toString() {
        return "ProfileServiceImpl{" +
                "name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", locale='" + locale + '\'' +
                ", messageBundle='" + messageBundle + '\'' +
                ", serverName='" + serverName + '\'' +
                ", serverHostIP='" + serverHostIP + '\'' +
                ", serverHostPort=" + serverHostPort +
                '}';
    }

    @PostConstruct
    public void xxx() {
        LOG.info(this.toString());
    }


}
