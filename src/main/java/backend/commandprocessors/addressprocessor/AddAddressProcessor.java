package backend.commandprocessors.addressprocessor;

import backend.commandprocessors.ICommandProcessor;
import backend.commands.address.AddAddress;
import backend.dto.IWebApiResponse;
import backend.dto.outgoing.AddressResponse;
import org.springframework.stereotype.Service;

@Service
public class AddAddressProcessor implements ICommandProcessor<AddAddress> {

    @Override
    public IWebApiResponse Process(AddAddress command) {
        //fetch entity based on command's values/id
        //persist the entity into DB
        //receive Id of newly created / updated entity
        //create a new response bean and set its id and other values
        AddressResponse response = new AddressResponse();
        response.setId(563434L);
        response.setLine1("Line1");
        response.setLine2("Line2");
        response.setArea("Ghatlodia");
        response.setCity("Ahmedabad");
        response.setState("Gujarat");
        response.setCountry("India");
        response.setZipCode("380001");
        return  response;
    }
}
