package com.github.jmodel.adapter.impl.persistence;

@FunctionalInterface
public interface Action<T, U, R> {

	R apply(T t, U u);
}
