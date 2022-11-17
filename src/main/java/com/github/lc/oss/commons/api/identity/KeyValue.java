package com.github.lc.oss.commons.api.identity;

public interface KeyValue<T> {
    String getKey();

    T getValue();
}
