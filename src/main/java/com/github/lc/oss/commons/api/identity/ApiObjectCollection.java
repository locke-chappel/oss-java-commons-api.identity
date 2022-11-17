package com.github.lc.oss.commons.api.identity;

import com.github.lc.oss.commons.serialization.JsonableCollection;

/**
 * Marker interface
 */
public interface ApiObjectCollection<T extends ApiObject> extends JsonableCollection<T>, ApiObject {

}
