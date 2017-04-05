package com.mycompany.app.catalog;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by okhoruzhenko on 3/27/17.
 */

public class CatalogEntryBook extends CatalogEntryAbstract {
    private int isbn;
    private String publisher;
    private Date publishDate;
    private String summary;
    private ArrayList<String> tags;
    private ArrayList<String> authors;


    @Override
    public boolean matches(CatalogEntryAbstract cea) {
        try {
            return matchesUnsafe(cea);
        } catch (NoSuchMethodException e) {}
        catch (ClassCastException e) {}
        return false;
    }

    public boolean matchesUnsafe(CatalogEntryAbstract cea) throws NoSuchMethodException, ClassCastException {
        if (cea == this) {
            return true;
        }

        CatalogEntryBook entry = (CatalogEntryBook) cea;

        if (entry.getTitle() != null) {
            if (!this.getTitle().contains(entry.getTitle())) {
                return false;
            }
        }

        if (entry.getPublisher() != null) {
            if (!entry.getPublisher().contains(this.getPublisher())) {
                return false;
            }
        }

        if (entry.getSummary() != null) {
            if (!entry.getSummary().contains(this.getSummary())) {
                return false;
            }
        }

        if (entry.getIsbn() != this.getIsbn()) {
            return false;
        }

        //Apparently date needs to be some time period instead of exact matching.
        if (entry.getPublishDate() != null) {
            if (entry.getPublishDate().compareTo(this.getPublishDate()) != 0) {
                return false;
            }
        }
        return true;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) { this.isbn = isbn; }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }
}
