package io.github.lc.oss.commons.api.identity;

public interface ApplicationInfo extends ApiObject {
    long getSessionTimeout();

    long getSessionMax();
}
