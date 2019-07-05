package com.mm.backend.common;

import java.io.Serializable;

/**
 * @ClassName ValueResponse
 * @Description TODO
 * @Date 2019/7/3 17:06
 */
public class ValueResponse<T> implements Serializable
{
    private T value;

    public static<T> ValueResponse<T> val(T value)
    {
        ValueResponse<T> instance = new ValueResponse<>();
        instance.value = value;

        return instance;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
