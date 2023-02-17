package io.github.lc.oss.commons.api.identity;

public interface ReissueRequest extends ApiObject {
    String getToken();

    String getApplicationId();
}
