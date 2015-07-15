package backend.service;

public interface ProfileService {

     String getName();
     String getVersion();
     String getReleaseDate();
     String getLocale();
     String getMessageBundle();

     String getServerName();
     String getServerHostIP();
     int getServerHostPort();

}
