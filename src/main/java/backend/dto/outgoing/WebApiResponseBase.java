package backend.dto.outgoing;

import backend.dto.IWebApiResponse;

/**
 * Created by zaidikkis on 15-Aug-15.
 */
public class WebApiResponseBase implements IWebApiResponse {

    private String _uri;

    @Override
    public String getUri() {
        return _uri == null ? "" : _uri;
    }

    @Override
    public void setUri(String uri) {
        _uri = uri;
    }

    private boolean redirectRequired;

    @Override
    public boolean getRedirectRequired() {
        return redirectRequired;
    }

    @Override
    public void setRedirectRequired(boolean redirectRequired) {
        this.redirectRequired = redirectRequired;
    }

    public static WebApiResponseBase Create(String uri, boolean redirectRequired)
    {
        WebApiResponseBase response = new WebApiResponseBase();
        response.setUri(uri);
        response.setRedirectRequired(redirectRequired);
        return response;
    }
}
