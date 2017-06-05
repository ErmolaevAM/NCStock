package nc.edu.ermolaxe.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by Александр on 31.05.2017.
 */
public class Image {

    private String id;

    private List<String> urls;

    public Image() {
    }

    public Image(String id, List<String> urls) {
        this.id = id;
        this.urls = urls;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id='" + id + '\'' + '\n'+
                ", urls=" + urls +
                '}';
    }
}
