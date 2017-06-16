package netcracker.wallpaperstock.ermolaxe.model.unsplash.model;

/**
 * Created by Александр on 31.05.2017.
 */
public class Urls {

    private String raw;

    private String full;

    private String regular;

    private String small;

    private String thumb;

    public Urls() {
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }

    public String getRegular() {
        return regular;
    }

    public void setRegular(String regular) {
        this.regular = regular;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    @Override
    public String toString() {
        return "Urls{" +
                "raw='" + raw + '\'' +'\n'+
                ", full='" + full + '\'' +'\n'+
                ", regular='" + regular + '\'' +'\n'+
                ", small='" + small + '\'' +'\n'+
                ", thumb='" + thumb + '\'' +'\n'+
                '}';
    }
}
