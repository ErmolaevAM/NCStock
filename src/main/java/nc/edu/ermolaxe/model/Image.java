package nc.edu.ermolaxe.model;


import java.util.List;

/**
 * Created by Александр on 31.05.2017.
 */
public class Image {

    private int width;

    private int height;

    private String username;

    private int likes;

    private List<String> tags;

    private String url;

    public Image() {
    }

    public Image(int width, int height, String user_name, int likes, List<String> tags, String url) {
        this.width = width;
        this.height = height;
        this.username = user_name;
        this.likes = likes;
        this.tags = tags;
        this.url = url;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
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
}
