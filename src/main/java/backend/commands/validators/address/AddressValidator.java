package backend.commands.validators.address;

import backend.commands.address.AddAddress;
import backend.commands.validators.BaseValidator;
import org.springframework.stereotype.Component;

@Component
public class AddressValidator implements BaseValidator<AddAddress> {

    @Override
    public boolean isValid(AddAddress command) {
        if(!command.getArea().equals("Ghatlodia")){
            return false;
        }
        return true;
    }
}
