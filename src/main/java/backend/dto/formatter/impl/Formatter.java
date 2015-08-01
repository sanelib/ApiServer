package backend.dto.formatter.impl;

/**
 * Created by Z21 on 01-Aug-15.
 */

public abstract class Formatter<T> {

    public abstract boolean apply(T obj);

    public boolean isNotEmpty(String s){
        return s != null && !s.trim().equals("");
    }

    public boolean isValidNumber(String s){
        if(s != null){
            try{
                Integer i = Integer.parseInt(s.trim());
                return true;
            }catch (Exception e){
                return false;
            }
        }
        else
            return false;
    }
}
