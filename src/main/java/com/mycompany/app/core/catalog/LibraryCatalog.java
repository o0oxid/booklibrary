package com.mycompany.app.core.catalog;

import com.mycompany.app.core.models.CatalogEntryAbstract;

import java.util.Set;

/**
 * Created by okhoruzhenko on 3/27/17.
 */
public interface LibraryCatalog<T extends CatalogEntryAbstract> {
    void add(T entry);
    void remove(T entry);
    Set<T> lookup(String text);
    Set<T> lookup(T entry);
}
