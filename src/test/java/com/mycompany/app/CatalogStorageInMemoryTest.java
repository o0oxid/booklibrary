package com.mycompany.app;

import com.mycompany.app.catalog.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * Created by okhoruzhenko on 4/11/17.
 */
public class CatalogStorageInMemoryTest {
    @Test
    public void CatalogBookStorageInMemory() {
        CatalogStorage<CatalogEntryBook> bookCatalog = new CatalogBookStorageInMemory();
        CatalogEntryBook book = new CatalogEntryBook();
        book.setTitle("Harry Potter and the Sorcerer's Stone");
        List<String> authors = new ArrayList<>();
        authors.add("J. K. Rowling");
        book.setAuthors(authors);
        bookCatalog.add(book);

        // Test catalog lookupEntity
        CatalogEntryBook lookupEntity = new CatalogEntryBook();
        lookupEntity.setTitle("Harry Potter");
        Set<CatalogEntryBook> result = bookCatalog.lookup(lookupEntity);
        assertEquals(result.size(),1);
    }

    @Test
    public void CatalogMagazineStorageInMemory() {
        CatalogStorage<CatalogEntryMagazine> magazineCatalog = new CatalogMagazineStorageInMemory();
        CatalogEntryMagazine magazine = new CatalogEntryMagazine();
        magazine.setTitle("Car");
        magazine.setCountry("UK");
        magazineCatalog.add(magazine);

        CatalogEntryMagazine lookupEntity = new CatalogEntryMagazine();
        lookupEntity.setTitle("car");
        lookupEntity.setCountry("UK");
        Set<CatalogEntryMagazine> result = magazineCatalog.lookup(lookupEntity);
        assertEquals(result.size(),1);
    }
}
