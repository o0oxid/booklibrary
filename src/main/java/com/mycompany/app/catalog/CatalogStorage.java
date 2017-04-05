package com.mycompany.app.catalog;

import java.util.Set;

/**
 * Created by okhoruzhenko on 3/27/17.
 */
public interface CatalogStorage {
    void add(CatalogEntryAbstract entry);
    void remove(CatalogEntryAbstract entry);
    Set<CatalogEntryAbstract> lookup(String text);
    Set<CatalogEntryAbstract> lookup(CatalogEntryAbstract entry);
}
