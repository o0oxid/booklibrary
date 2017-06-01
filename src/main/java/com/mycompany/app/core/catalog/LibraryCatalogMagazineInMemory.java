package com.mycompany.app.core.catalog;

import com.mycompany.app.core.models.CatalogEntryMagazine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * Created by okhoruzhenko on 4/10/17.
 */

public class LibraryCatalogMagazineInMemory implements LibraryCatalog<CatalogEntryMagazine> {
    protected final Collection<CatalogEntryMagazine> catalog;

    public LibraryCatalogMagazineInMemory(Collection<CatalogEntryMagazine> catalog) {
        this.catalog = catalog;
    }

    public LibraryCatalogMagazineInMemory() {
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
                .filter(e -> e.getTitle().toLowerCase().contains(text.toLowerCase()))
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
