package netcracker.wallpaperstock.ermolaxe.model;

import java.util.List;

/**
 * Created by Александр on 13.06.2017.
 */
public class Image {
    private long width;

    private long height;

    private String username;

    private long likes;

    private List<String> tags;

    private String url;

    public Image() {
    }

    public Image(long width, long height, String username, long likes, List<String> tags, String url) {
        this.width = width;
        this.height = height;
        this.username = username;
        this.likes = likes;
        this.tags = tags;
        this.url = url;
    }

    public long getWidth() {
        return width;
    }

    public void setWidth(long width) {
        this.width = width;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Image{" +
                "width=" + width +
                ", height=" + height +
                ", username='" + username + '\'' +
                ", likes=" + likes +
                ", tags=" + tags +
                ", url='" + url + '\'' +
                '}';
    }
}
