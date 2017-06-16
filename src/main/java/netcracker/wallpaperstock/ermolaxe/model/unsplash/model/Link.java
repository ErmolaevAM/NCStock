package netcracker.wallpaperstock.ermolaxe.model.unsplash.model;

/**
 * Created by Александр on 31.05.2017.
 */
public class Link {

    private String self;

    private String html;

    private String photos;

    private String likes;

    private String portfolio;

    private String following;

    private String followers;

    private String download;

    private String download_location;

    public Link() {
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getDownload() {
        return download;
    }

    public void setDownload(String download) {
        this.download = download;
    }

    public String getDownload_location() {
        return download_location;
    }

    public void setDownload_location(String download_location) {
        this.download_location = download_location;
    }

    @Override
    public String toString() {
        return "Link{" +
                "self='" + self + '\'' +
                ", html='" + html + '\'' +
                ", photos='" + photos + '\'' +
                ", likes='" + likes + '\'' +
                ", portfolio='" + portfolio + '\'' +
                ", following='" + following + '\'' +
                ", followers='" + followers + '\'' +
                ", download='" + download + '\'' +
                ", download_location='" + download_location + '\'' +
                '}';
    }
}
