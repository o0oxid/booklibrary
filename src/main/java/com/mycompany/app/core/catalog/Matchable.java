package com.mycompany.app.core.catalog;

/**
 * Created by okhoruzhenko on 4/4/17.
 */
public interface Matchable<T> {
    boolean matches(T t);
}
