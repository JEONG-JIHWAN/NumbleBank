package com.bankingserver.numblebank.user.auth;

public interface JwtProperties {
    String SECRET = "numble";
    int EXPIRATION_TIME = 60000*20;
    String TOKEN_PREFIX = "Bearer ";
    String HEADER_STRING = "Authorization";
}
