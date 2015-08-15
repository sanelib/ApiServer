package backend.dto;

/**
 * Created by zaidikkis on 15-Aug-15.
 */
public interface IWebApiResponse {

    String getUri();
    void setUri(String uri);

    boolean getRedirectRequired();
    void setRedirectRequired(boolean redirectRequired);
}
