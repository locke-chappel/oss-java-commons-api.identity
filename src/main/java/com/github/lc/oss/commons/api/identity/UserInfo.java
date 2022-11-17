package com.github.lc.oss.commons.api.identity;

import java.util.Map;
import java.util.Set;

public interface UserInfo extends ApiObject {
    String getId();

    String getUsername();

    String getDisplayName();

    String getPreferredTheme();

    Set<String> getPermissions();

    Map<String, String> getUserData();
}
