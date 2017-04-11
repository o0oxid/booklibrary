package com.mycompany.app;

import com.mycompany.app.catalog.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CatalogStorage<CatalogEntryBook> bookCatalog = new CatalogBookStorageInMemory();
        CatalogEntryBook book = new CatalogEntryBook();
        book.setTitle("Harry Potter and the Sorcerer's Stone");
        List<String> authors = new ArrayList<>();
        authors.add("J. K. Rowling");
        book.setAuthors(authors);
        bookCatalog.add(book);

        CatalogStorage<CatalogEntryMagazine> magazineCatalog = new CatalogMagazineStorageInMemory();
        CatalogEntryMagazine magazine = new CatalogEntryMagazine();
        magazine.setTitle("Car");
        magazine.setCountry("United Kingdom");

        magazineCatalog.add(magazine);

        CatalogEntryBook lookup = new CatalogEntryBook();
        lookup.setTitle("Harry Potter");
        Set<CatalogEntryBook> result = bookCatalog.lookup(lookup);
        System.out.print(result);
    }
}
