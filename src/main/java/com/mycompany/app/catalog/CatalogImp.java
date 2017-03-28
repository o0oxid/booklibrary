package com.mycompany.app.catalog;

/**
 * Created by okhoruzhenko on 3/27/17.
 */
public class CatalogImp implements Catalog {
    CatalogStorage storage;
    public CatalogImp(CatalogStorage storage) {
        this.storage = storage;
    }

    @Override
    public void add(CatalogEntryAbstract entry) {
        storage.add(entry);
    }

    @Override
    public void remove(CatalogEntryAbstract entry) {
        storage.remove(entry);
    }

    @Override
    public CatalogEntryAbstract lookup(String text) {
        return storage.lookup(text);
    }
}
