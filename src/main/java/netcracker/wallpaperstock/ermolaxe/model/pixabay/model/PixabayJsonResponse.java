package netcracker.wallpaperstock.ermolaxe.model.pixabay.model;

import java.util.List;

/**
 * Created by Александр on 11.06.2017.
 */
public class PixabayJsonResponse {

    private int totalHits;

    private List<PixabayImage> hits;

    private int total;

    public PixabayJsonResponse() {
    }

    public int getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(int totalHits) {
        this.totalHits = totalHits;
    }

    public List<PixabayImage> getHits() {
        return hits;
    }

    public void setHits(List<PixabayImage> hits) {
        this.hits = hits;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
