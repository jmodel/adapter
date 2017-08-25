package com.github.jmodel.adapter.api.persistence;

@FunctionalInterface
public interface Action<T, U, R> {

	R apply(T t, U u);
}
