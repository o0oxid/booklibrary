package com.mycompany.app.catalog;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * Created by okhoruzhenko on 3/27/17.
 */
public class CatalogBookStorageInMemory extends CatalogStorageInMemoryAbstract<CatalogEntryBook>  {
    public Set<CatalogEntryBook> lookup(final CatalogEntryBook entry) {
        Set<CatalogEntryBook> result = catalog.stream()
                .filter(e -> e.matches(entry))
                .collect(Collectors.toSet());
        return result;
    }
}
