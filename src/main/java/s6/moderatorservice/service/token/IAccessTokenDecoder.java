package s6.moderatorservice.service.token;


import s6.moderatorservice.configuration.AccessToken;

public interface IAccessTokenDecoder {
    AccessToken decode(String accessTokenEncoded);
}
