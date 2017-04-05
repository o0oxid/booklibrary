package com.mycompany.app.catalog;

/**
 * Created by okhoruzhenko on 3/27/17.
 */
public class CatalogEntryMagazine extends CatalogEntryAbstract {
    private int series;
    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean matches(CatalogEntryAbstract cea) {
        try {
            return matchesUnsafe(cea);
        } catch (NoSuchMethodException e) {}
        catch (ClassCastException e) {}
        finally {
            return false;
        }
    }

    public boolean matchesUnsafe(CatalogEntryAbstract cea) throws NoSuchMethodException, ClassCastException {
        if (cea == this) {
            return true;
        }

        CatalogEntryMagazine entry = (CatalogEntryMagazine) cea;

        if (entry.getTitle() != null) {
            if (!this.getTitle().contains(entry.getTitle())) {
                return false;
            }
        }

        if (entry.getCountry() != null) {
            if (!this.getCountry().contains(entry.getCountry())) {
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
