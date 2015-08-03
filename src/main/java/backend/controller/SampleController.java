package backend.controller;

import backend.commands.Address.AddAddress;
import backend.dto.Address;
import backend.dto.formatter.impl.Formatter;
import backend.init.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * Created by zaidikkis on 01-Aug-15.
 */

@Controller
public class SampleController {

    @Autowired
    @Qualifier(value = "AddressFormatter")
    private Formatter<Address> addressFormatter;

    public boolean mapping(Address dto){
        boolean isValidFormat = addressFormatter.apply(dto);
        if(!isValidFormat){
            return false;
        }
        ModelMapper mapper = Mapper.getInstance();
        AddAddress command = mapper.map(dto, AddAddress.class);

        System.out.println("Address{" +
                "line1='" + command.getLine1() + '\'' +
                ", line2='" + command.getLine2() + '\'' +
                ", Area='" + command.getArea() + '\'' +
                ", City='" + command.getCity() + '\'' +
                ", State='" + command.getState() + '\'' +
                ", Country='" + command.getCountry() + '\'' +
                ", zipCode='" + command.getZipCode() + '\'' +
                '}');
        return true;
    }
}