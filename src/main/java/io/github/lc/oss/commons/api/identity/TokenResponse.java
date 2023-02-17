package io.github.lc.oss.commons.api.identity;

public interface TokenResponse extends ApiObject {
    Long getExpiration();

    String getToken();
}
