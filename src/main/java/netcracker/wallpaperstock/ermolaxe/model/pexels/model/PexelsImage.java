package netcracker.wallpaperstock.ermolaxe.model.pexels.model;

/**
 * Created by Александр on 12.06.2017.
 */
public class PexelsImage {

    private int width;

    private int height;

    private String url;

    private String photographer;

    private SRC src;

    public PexelsImage() {
    }

    public long getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public long getHeight() {
        return height;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPhotographer() {
        return photographer;
    }

    public void setPhotographer(String photographer) {
        this.photographer = photographer;
    }

    public SRC getSrc() {
        return src;
    }

    public void setSrc(SRC src) {
        this.src = src;
    }
}
