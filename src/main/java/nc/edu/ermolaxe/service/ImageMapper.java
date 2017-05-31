package nc.edu.ermolaxe.service;

import nc.edu.ermolaxe.model.Image;
import nc.edu.ermolaxe.model.unsplash.model.UnsplashImage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Александр on 31.05.2017.
 */
public class ImageMapper {

    public static List<Image> change(List<UnsplashImage> list) {
        List<Image> images = new ArrayList<Image>();
        for (UnsplashImage img : list) {
            Image image = new Image();
            image.setId(img.getId());
            image.setUrls(img.getUrls());
            images.add(image);
        }
        return images;
    }
}
