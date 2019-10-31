package com.gurkan.dms.interfaces;


import com.gurkan.dms.exception.ValidatorException;

public interface IValidator<T> {
    void validate(T t) throws ValidatorException;
}
