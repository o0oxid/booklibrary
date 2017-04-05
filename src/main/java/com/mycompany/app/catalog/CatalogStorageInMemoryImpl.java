package com.mycompany.app.catalog;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * Created by okhoruzhenko on 3/27/17.
 */
public class CatalogStorageInMemoryImpl implements CatalogStorage {
    private ArrayList<CatalogEntryAbstract> catalog = new ArrayList<>();

    public void add(CatalogEntryAbstract entry) {
        catalog.add(entry);
    }
    public void remove(CatalogEntryAbstract entry) {
        catalog.remove(entry);
    }

    public Set<CatalogEntryAbstract> lookup(final String text) {
        Set<CatalogEntryAbstract> result = catalog.stream()
                 .filter(e -> e.getTitle().matches(text))
                 .collect(Collectors.toSet());
        return result;
    }

    public Set<CatalogEntryAbstract> lookup(final CatalogEntryAbstract entry) {
        Set<CatalogEntryAbstract> result = catalog.stream()
                .filter(e -> e.matches(entry))
                .collect(Collectors.toSet());
        return result;
    }
}
