package com.mycompany.app.catalog;

import com.mycompany.app.models.CatalogEntryAbstract;

import java.util.Set;

/**
 * Created by okhoruzhenko on 3/27/17.
 */
public interface Catalog<T extends CatalogEntryAbstract> {
    void add(T entry);
    void remove(T entry);
    Set<T> lookup(String text);
    Set<T> lookup(T entry);
}
