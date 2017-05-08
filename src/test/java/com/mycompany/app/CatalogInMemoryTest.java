package com.mycompany.app;

import com.mycompany.app.catalog.*;
import com.mycompany.app.models.CatalogEntryBook;
import com.mycompany.app.models.CatalogEntryMagazine;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * Created by okhoruzhenko on 4/11/17.
 */
public class CatalogInMemoryTest {
    @Test
    public void CatalogBookStorageInMemory() {
        Catalog<CatalogEntryBook> bookCatalog = new CatalogBookInMemory();
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
        Catalog<CatalogEntryMagazine> magazineCatalog = new CatalogMagazineInMemory();
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
