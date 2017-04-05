package com.mycompany.app;

import com.mycompany.app.catalog.CatalogEntryAbstract;
import com.mycompany.app.catalog.CatalogEntryBook;
import com.mycompany.app.catalog.CatalogEntryMagazine;
import com.mycompany.app.catalog.CatalogStorageInMemoryImpl;

import java.util.ArrayList;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CatalogStorageInMemoryImpl catalog = new CatalogStorageInMemoryImpl();
        CatalogEntryBook book = new CatalogEntryBook();

        book.setTitle("Harry Potter and the Sorcerer's Stone");
        ArrayList<String> authors = new ArrayList<>();
        authors.add("J. K. Rowling");
        book.setAuthors(authors);

        CatalogEntryMagazine magazine = new CatalogEntryMagazine();
        magazine.setTitle("Car");
        magazine.setCountry("United Kingdom");


        catalog.add(book);
        catalog.add(magazine);

        CatalogEntryBook lookup = new CatalogEntryBook();
        lookup.setTitle("Harry Potter");
        Set<CatalogEntryAbstract> result = catalog.lookup(lookup);
        System.out.print(result);
    }
}
