package backend.service.impl;

import backend.ApplicationSetup;
import backend.service.ProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ProfileServiceImpl implements ProfileService {

    private static final Logger LOG = LoggerFactory.getLogger(ApplicationSetup.class);

    @Value("${name}")
    private String name;

    @Value("${server.name}")
    private String serverName;

    @Value("${server.host.ip}")
    private String serverHostIP;

    @Value("${server.host.port}")
    private int serverHostPort;

    public String getName() {
        return name;
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
                ", serverName='" + serverName + '\'' +
                ", serverHostIP='" + serverHostIP + '\'' +
                ", serverHostPort=" + serverHostPort +
                '}';
    }

    @PostConstruct
    public void xxx() {
        LOG.info(this.toString());
    }

    @Override
    public String getToString() {
        return this.toString();
    }
}
