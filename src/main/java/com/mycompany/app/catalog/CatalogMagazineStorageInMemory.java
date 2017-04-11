package com.mycompany.app.catalog;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by okhoruzhenko on 4/10/17.
 */
public class CatalogMagazineStorageInMemory extends CatalogStorageInMemoryAbstract<CatalogEntryMagazine>  {
    public Set<CatalogEntryMagazine> lookup(final CatalogEntryMagazine entry) {
        Set<CatalogEntryMagazine> result = catalog.stream()
                .filter(e -> e.matches(entry))
                .collect(Collectors.toSet());
        return result;
    }
}
