package netcracker.wallpaperstock.ermolaxe.service;

import netcracker.wallpaperstock.ermolaxe.model.Image;

import java.util.List;

/**
 * Created by Александр on 13.06.2017.
 */
public interface ImageServiceDAO {
    List<Image> getImageList();
    List<Image> getPhotoByTag(String tag, int count);
}
