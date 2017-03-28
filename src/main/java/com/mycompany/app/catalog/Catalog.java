package com.mycompany.app.catalog;

/**
 * Created by okhoruzhenko on 3/26/17.
 */
public interface Catalog {
    void add(CatalogEntryAbstract entry);
    void remove(CatalogEntryAbstract entry);
    CatalogEntryAbstract lookup(String text);
}
