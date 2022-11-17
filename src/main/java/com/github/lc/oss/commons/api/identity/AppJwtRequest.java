package com.github.lc.oss.commons.api.identity;

import java.util.Collection;
import java.util.Map;

public interface AppJwtRequest extends ApiObject {
    /**
     * Duration in milliseconds the JWT should be valid for
     */
    long getTtl();

    /**
     * Permissions the JWT should be issued for.
     *
     * The format is App External ID = [ permission code array ]
     */
    Map<String, Collection<String>> getPermissions();
}
