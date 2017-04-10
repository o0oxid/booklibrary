package com.mycompany.app.catalog;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.org.apache.xml.internal.resolver.CatalogEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * Created by okhoruzhenko on 3/27/17.
 */

public class CatalogEntryBook extends CatalogEntryAbstract implements Matchable<CatalogEntryBook> {
    private int isbn;
    private String publisher;
    private Date publishDate;
    private String summary;
    private List<String> tags;
    private List<String> authors;


    @Override
    public boolean matches(CatalogEntryBook entry) {
        if (entry == this) {
            return true;
        }

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

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }
}
