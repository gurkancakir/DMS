package com.gurkan.dms.interfaces;

public interface IConverter<T, V> {
    V convert(T obj);
}
