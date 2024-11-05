package s6.moderatorservice.service.token;


import s6.moderatorservice.configuration.AccessToken;

public interface IAccessTokenEncoder {
    String encode(AccessToken accessToken);
}
