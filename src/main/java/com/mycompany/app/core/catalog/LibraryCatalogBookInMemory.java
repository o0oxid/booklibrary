package com.mycompany.app.core.catalog;

import com.mycompany.app.core.models.CatalogEntryBook;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * Created by okhoruzhenko on 3/27/17.
 */
public class LibraryCatalogBookInMemory implements LibraryCatalog<CatalogEntryBook> {
    protected final Collection<CatalogEntryBook> catalog;

    public LibraryCatalogBookInMemory(Collection<CatalogEntryBook> catalog) {
        this.catalog = catalog;
    }

    public LibraryCatalogBookInMemory() {
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
                .filter(e -> e.getTitle().toLowerCase().contains(text.toLowerCase()))
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
