package api;

import org.scribe.builder.api.DefaultApi10a;
import org.scribe.model.OAuthConfig;
import org.scribe.model.Token;
import org.scribe.oauth.OAuth10aServiceImpl;
import org.scribe.oauth.OAuthService;

public class DrupalApi extends DefaultApi10a {

private static final String AUTHORIZATION_URL = "http://YOURDRUPALURL/oauth/authorize?oauth_token=%s";
private static final String BASE_URL = "http://YOURDRUPALURL/oauth/";

  @Override
  public String getRequestTokenEndpoint()
  {
    return BASE_URL + "request_token";
  }

  @Override
  public String getAccessTokenEndpoint()
  {
    return BASE_URL + "access_token";
  }
 
  @Override
  public String getAuthorizationUrl(Token requestToken)
  {
    return String.format(AUTHORIZATION_URL, requestToken.getToken());
  }
 
  @Override
  public OAuthService createService(OAuthConfig config)
  {
    return new OAuth10aServiceImpl(this, config);
  }
}