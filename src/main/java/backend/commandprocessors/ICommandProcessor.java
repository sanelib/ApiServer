package backend.commandprocessors;

import backend.commands.ICommand;
import backend.dto.IWebApiResponse;

/**
 * Created by zaidikkis on 15-Aug-15.
 */
public interface ICommandProcessor<T extends ICommand> {
    IWebApiResponse Process(T command);
}
