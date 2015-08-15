package backend.controllerapis;

import backend.commandprocessors.ICommandProcessor;
import backend.commands.ICommand;
import backend.dto.IWebApiResponse;
import backend.dto.outgoing.WebApiResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.beans.Introspector;

@Controller
public class BaseApiController {

    @Autowired
    private ApplicationContext context;

    public ResponseEntity<IWebApiResponse> ProcessRequest(ICommand command)
    {
        IWebApiResponse response = new WebApiResponseBase();

        try{
            String processorName = Introspector.decapitalize(command.getClass().getSimpleName() + "Processor");
            ICommandProcessor processor = (ICommandProcessor) context.getBean(processorName);
            response = processor.Process(command);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
