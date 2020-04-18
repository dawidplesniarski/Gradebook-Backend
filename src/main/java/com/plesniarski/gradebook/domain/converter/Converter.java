package com.plesniarski.gradebook.domain.converter;

import java.util.Optional;

@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
}
