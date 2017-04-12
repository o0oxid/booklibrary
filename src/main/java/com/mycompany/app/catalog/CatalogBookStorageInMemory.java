package com.mycompany.app.catalog;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * Created by okhoruzhenko on 3/27/17.
 */
public class CatalogBookStorageInMemory implements CatalogStorage<CatalogEntryBook>  {
    protected Collection<CatalogEntryBook> catalog;

    public CatalogBookStorageInMemory(Collection<CatalogEntryBook> catalog) {
        this.catalog = catalog;
    }

    public CatalogBookStorageInMemory() {
        catalog = new ArrayList<>();
    }

    public void add(CatalogEntryBook entry) {
        catalog.add(entry);
    }
    public void remove(CatalogEntryBook entry) {
        catalog.remove(entry);
    }

    @Override
    public Set<CatalogEntryBook> lookup(final String text) {
        Set<CatalogEntryBook> result = catalog.stream()
                .filter(e -> e.getTitle().matches(text))
                .collect(Collectors.toSet());
        return result;
    }
    public Set<CatalogEntryBook> lookup(final CatalogEntryBook entry) {
        Set<CatalogEntryBook> result = catalog.stream()
                .filter(e -> e.matches(entry))
                .collect(Collectors.toSet());
        return result;
    }
}
