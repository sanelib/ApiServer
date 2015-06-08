package backend.service.impl;

import backend.service.ProfileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({ "default", "dev", "test" })
public class ProfileServiceImpl implements ProfileService {

    @Value("${name:World}")
    private String name;

    @Override
    public String getMessage() {
        return "Hello " + this.name;
    }
}
