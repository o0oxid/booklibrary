package com.mycompany.app.catalog;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by okhoruzhenko on 4/10/17.
 */
public class CatalogMagazineStorageInMemory implements CatalogStorage<CatalogEntryMagazine>  {
    protected Collection<CatalogEntryMagazine> catalog;

    public CatalogMagazineStorageInMemory(Collection<CatalogEntryMagazine> catalog) {
        this.catalog = catalog;
    }

    public CatalogMagazineStorageInMemory() {
        catalog = new ArrayList<>();
    }

    public void add(CatalogEntryMagazine entry) {
        catalog.add(entry);
    }
    public void remove(CatalogEntryMagazine entry) {
        catalog.remove(entry);
    }

    @Override
    public Set<CatalogEntryMagazine> lookup(final String text) {
        Set<CatalogEntryMagazine> result = catalog.stream()
                .filter(e -> e.getTitle().matches(text))
                .collect(Collectors.toSet());
        return result;
    }
    @Override
    public Set<CatalogEntryMagazine> lookup(final CatalogEntryMagazine entry) {
        Set<CatalogEntryMagazine> result = catalog.stream()
                .filter(e -> e.matches(entry))
                .collect(Collectors.toSet());
        return result;
    }
}
