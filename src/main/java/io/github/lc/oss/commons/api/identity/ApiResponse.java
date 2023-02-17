package io.github.lc.oss.commons.api.identity;

import java.util.Collection;

import io.github.lc.oss.commons.serialization.Jsonable;

public interface ApiResponse<T extends ApiObject> extends Jsonable {
    T getBody();

    Collection<Messages> getMessages();
}
