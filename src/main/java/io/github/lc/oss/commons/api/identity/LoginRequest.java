package io.github.lc.oss.commons.api.identity;

public interface LoginRequest extends Credentials {
    String getApplicationId();
}
