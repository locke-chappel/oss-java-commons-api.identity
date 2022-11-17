package com.github.lc.oss.commons.api.identity;

import java.util.Collection;

import com.github.lc.oss.commons.serialization.Jsonable;

public interface ApiResponse<T extends ApiObject> extends Jsonable {
    T getBody();

    Collection<Messages> getMessages();
}
