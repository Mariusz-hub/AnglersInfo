package com.angler.utils;

@FunctionalInterface
public interface MapperDto<T,F> {

    T map(F from);
}
