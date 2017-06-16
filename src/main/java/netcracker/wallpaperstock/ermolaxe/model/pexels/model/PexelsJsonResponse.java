package netcracker.wallpaperstock.ermolaxe.model.pexels.model;

import java.util.List;

/**
 * Created by Александр on 12.06.2017.
 */
public class PexelsJsonResponse {

    private int page;

    private int per_page;

    private int total_results;

    private String url;

    private String next_page;

    private List<PexelsImage> photos;

    public PexelsJsonResponse() {
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNext_page() {
        return next_page;
    }

    public void setNext_page(String next_page) {
        this.next_page = next_page;
    }

    public List<PexelsImage> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PexelsImage> photos) {
        this.photos = photos;
    }
}
