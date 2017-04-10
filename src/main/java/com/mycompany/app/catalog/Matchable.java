package com.mycompany.app.catalog;

/**
 * Created by okhoruzhenko on 4/4/17.
 */
public interface Matchable<T> {
    boolean matches(T t);
}
