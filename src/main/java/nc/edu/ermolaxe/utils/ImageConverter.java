package nc.edu.ermolaxe.utils;

import nc.edu.ermolaxe.model.Image;
import nc.edu.ermolaxe.model.unsplash.model.UnsplashImage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Александр on 31.05.2017.
 */
public class ImageConverter  {
    private static final Logger LOGGER = LoggerFactory.getLogger(ImageConverter.class);

    public static List<Image> convertImageFromUnsplash(List<UnsplashImage> list) {
        List<Image> images = new ArrayList<Image>();
        for (UnsplashImage img : list) {
            Image image = new Image();
            image.setId(img.getId());
            image.setUrls(img.getUrls());
            images.add(image);
        }
        LOGGER.info("Convert from UnsplashImage class to default Image class.");
        return images;
    }
}
