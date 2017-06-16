package netcracker.wallpaperstock.ermolaxe.model.unsplash.model;

/**
 * Created by Александр on 31.05.2017.
 */
public class ProfileImage {

    private String small;

    private String medium;

    private String large;

    public ProfileImage() {
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    @Override
    public String toString() {
        return "ProfileImage{" +
                "small='" + small + '\'' +'\n'+
                ", medium='" + medium + '\'' +'\n'+
                ", large='" + large + '\'' +'\n'+
                '}';
    }
}
