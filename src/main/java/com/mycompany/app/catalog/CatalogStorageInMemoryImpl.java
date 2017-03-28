package com.mycompany.app.catalog;

import java.util.ArrayList;

/**
 * Created by okhoruzhenko on 3/27/17.
 */
public class CatalogStorageInMemoryImpl implements CatalogStorage {
    private ArrayList<CatalogEntryAbstract> books = new ArrayList<CatalogEntryAbstract>();

    public void add(CatalogEntryAbstract entry) {
        books.add(entry);
    }
    public void remove(CatalogEntryAbstract entry) {
        books.remove(entry);
    }
    public CatalogEntryAbstract lookup(final String text) {
        CatalogEntryAbstract entry = books.stream()
                                      .filter(e -> e.getTitle().matches(text))
                                      .findFirst()
                                      .orElse(null);
        return entry;
    }
}
