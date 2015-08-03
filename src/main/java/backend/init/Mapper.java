package backend.init;

import org.modelmapper.ModelMapper;

/**
 * Created by zaidikkis on 01-Aug-15.
 */
public class Mapper {
    private static volatile ModelMapper SINGLETON = new ModelMapper();

    private Mapper(){  }

    public static final ModelMapper getInstance(){
        return SINGLETON;
    }
}
