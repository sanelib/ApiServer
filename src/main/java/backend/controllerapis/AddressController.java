package backend.controllerapis;

import backend.commands.address.AddAddress;
import backend.commands.validators.address.AddressValidator;
import backend.dto.Address;
import backend.dto.IWebApiResponse;
import backend.dto.formatter.impl.AddressFormatter;
import backend.init.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class AddressController extends BaseApiController {

    @Autowired
    private AddressFormatter addressFormatter;

    @Autowired
    private AddressValidator addressValidator;

    public ResponseEntity<IWebApiResponse> add(Address form){
        boolean isValidFormat = addressFormatter.apply(form);
        if(!isValidFormat){
            return null;
        }
        ModelMapper mapper = Mapper.getInstance();
        AddAddress command = mapper.map(form, AddAddress.class);
        boolean isValidCommand = addressValidator.isValid(command);
        if(!isValidCommand){
            return null;
        }
        return ProcessRequest(command);
    }
}
