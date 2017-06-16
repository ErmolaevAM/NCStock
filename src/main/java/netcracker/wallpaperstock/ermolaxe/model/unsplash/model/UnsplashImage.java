package netcracker.wallpaperstock.ermolaxe.model.unsplash.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Александр on 31.05.2017.
 */
public class UnsplashImage {

    private String id;

    private String created_at;

    private String updated_at;

    private int width;

    private int height;

    private String color;

    private int likes;

    private boolean liked_by_user;

    private User user;

    private List<String> current_user_collections;

    private Urls urls;

    private List<String> categories;

    private Link links;

    /*------constructors and get/set methods------*/

    public UnsplashImage() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public boolean isLiked_by_user() {
        return liked_by_user;
    }

    public void setLiked_by_user(boolean liked_by_user) {
        this.liked_by_user = liked_by_user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getCurrent_user_collections() {
        return current_user_collections;
    }

    public void setCurrent_user_collections(List<String> current_user_collections) {
        this.current_user_collections = current_user_collections;
    }

    public List<String> getUrls() {
        List<String> tmp = new ArrayList<String>();

        if (urls.getFull()!=null) tmp.add(urls.getFull());
        if (urls.getRaw()!=null) tmp.add(urls.getRaw());
        if (urls.getRegular()!=null) tmp.add(urls.getRegular());
        if (urls.getSmall()!=null) tmp.add(urls.getSmall());
        if (urls.getThumb()!=null) tmp.add(urls.getThumb());

        return tmp;
    }

    public void setUrls(Urls urls) {
        this.urls = urls;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public Link getLinks() {
        return links;
    }

    public void setLinks(Link links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "UnsplashImage{" +
                "id='" + id + '\'' + '\n'+
                ", created_at='" + created_at + '\'' +'\n'+
                ", updated_at='" + updated_at + '\'' +'\n'+
                ", width=" + width +'\n'+
                ", height=" + height +'\n'+
                ", color='" + color + '\'' +'\n'+
                ", likes=" + likes +'\n'+
                ", liked_by_user=" + liked_by_user +'\n'+
                ", user=" + user +'\n'+
                ", current_user_collections=" + current_user_collections +'\n'+
                ", urls=" + urls +'\n'+
                ", categories=" + categories +'\n'+
                ", links=" + links +'\n'+
                '}';
    }
}
