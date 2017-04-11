package com.mycompany.app.catalog;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by okhoruzhenko on 4/9/17.
 */
public abstract class CatalogStorageInMemoryAbstract<T extends CatalogEntryAbstract> implements CatalogStorage<T> {
    protected ArrayList<T> catalog = new ArrayList<>();

    public void add(T entry) {
        catalog.add(entry);
    }
    public void remove(T entry) {
        catalog.remove(entry);
    }

    public Set<T> lookup(final String text) {
        Set<T> result = catalog.stream()
                .filter(e -> e.getTitle().matches(text))
                .collect(Collectors.toSet());
        return result;
    }
}
