package com.mycompany.app.models;

import com.mycompany.app.catalog.Matchable;

/**
 * Created by okhoruzhenko on 3/27/17.
 */
public class CatalogEntryMagazine extends CatalogEntryAbstract implements Matchable<CatalogEntryMagazine> {
    private int series;
    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean matches(CatalogEntryMagazine entry) {
        if (entry == this) {
            return true;
        }

        if (entry.getTitle() != null) {
            if (!this.getTitle().toLowerCase().contains(entry.getTitle().toLowerCase())) {
                return false;
            }
        }

        if (entry.getCountry() != null) {
            if (!this.getCountry().toLowerCase().contains(entry.getCountry().toLowerCase())) {
                return false;
            }
        }

        if (entry.getSeries() != this.getSeries()) {
            return false;
        }

        return true;
    }

    public int getSeries() {
        return series;
    }
    public void setSeries(int series) {
        this.series = series;
    }
}
