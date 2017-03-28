package com.mycompany.app.catalog;

/**
 * Created by okhoruzhenko on 3/27/17.
 */
public interface CatalogStorage {
    void add(CatalogEntryAbstract entry);
    void remove(CatalogEntryAbstract entry);
    CatalogEntryAbstract lookup(String text);
}
