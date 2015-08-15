package backend.commands.validators;

import backend.commands.ICommand;
import org.springframework.stereotype.Component;

@Component
public interface BaseValidator<T extends ICommand> {
    boolean isValid(T command);
}
