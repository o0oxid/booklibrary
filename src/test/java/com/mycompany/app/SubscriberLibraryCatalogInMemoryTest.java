package com.mycompany.app;

import com.mycompany.app.core.catalog.*;
import com.mycompany.app.core.models.CatalogEntryBook;
import com.mycompany.app.core.models.CatalogEntryMagazine;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * Created by okhoruzhenko on 4/11/17.
 */
public class SubscriberLibraryCatalogInMemoryTest {
    @Test
    public void CatalogBookStorageInMemory() {
        LibraryCatalog<CatalogEntryBook> bookLibraryCatalog = new LibraryCatalogBookInMemory();
        CatalogEntryBook book = new CatalogEntryBook();
        book.setTitle("Harry Potter and the Sorcerer's Stone");
        List<String> authors = new ArrayList<>();
        authors.add("J. K. Rowling");
        book.setAuthors(authors);
        bookLibraryCatalog.add(book);

        // Test catalog lookupEntity
        CatalogEntryBook lookupEntity = new CatalogEntryBook();
        lookupEntity.setTitle("Harry Potter");
        Set<CatalogEntryBook> result = bookLibraryCatalog.lookup(lookupEntity);
        assertEquals(result.size(),1);
    }

    @Test
    public void CatalogMagazineStorageInMemory() {
        LibraryCatalog<CatalogEntryMagazine> magazineLibraryCatalog = new LibraryCatalogMagazineInMemory();
        CatalogEntryMagazine magazine = new CatalogEntryMagazine();
        magazine.setTitle("Car");
        magazine.setCountry("UK");
        magazineLibraryCatalog.add(magazine);

        CatalogEntryMagazine lookupEntity = new CatalogEntryMagazine();
        lookupEntity.setTitle("car");
        lookupEntity.setCountry("UK");
        Set<CatalogEntryMagazine> result = magazineLibraryCatalog.lookup(lookupEntity);
        assertEquals(result.size(),1);
    }
}
