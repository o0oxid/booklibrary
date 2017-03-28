package com.mycompany.app.catalog;

import java.io.Serializable;

/**
 * Created by okhoruzhenko on 3/26/17.
 */
public abstract class CatalogEntryAbstract implements Serializable{
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
