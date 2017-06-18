package netcracker.wallpaperstock.ermolaxe.model.unsplash.model;

import java.util.List;

/**
 * Created by Александр on 18.06.2017.
 */
public class UnsplashJsonResponse {
    private long total;

    private long total_pages;

    private List<UnsplashImage> results;

    public UnsplashJsonResponse() {
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(long total_pages) {
        this.total_pages = total_pages;
    }

    public List<UnsplashImage> getResults() {
        return results;
    }

    public void setResults(List<UnsplashImage> results) {
        this.results = results;
    }
}
