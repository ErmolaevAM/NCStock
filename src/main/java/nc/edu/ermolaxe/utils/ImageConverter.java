package nc.edu.ermolaxe.utils;

import nc.edu.ermolaxe.model.Image;
import nc.edu.ermolaxe.model.pexels.model.PexelsImage;
import nc.edu.ermolaxe.model.pexels.model.PexelsJsonResponse;
import nc.edu.ermolaxe.model.pixabay.model.PixabayImage;
import nc.edu.ermolaxe.model.pixabay.model.PixabayJsonResponse;
import nc.edu.ermolaxe.model.unsplash.model.UnsplashImage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static javafx.scene.input.KeyCode.L;

/**
 * Created by Александр on 31.05.2017.
 */
public class ImageConverter  {
    private static final Logger LOGGER = LoggerFactory.getLogger(ImageConverter.class);

    public static List<Image> convertImageFromUnsplash(List<UnsplashImage> list) {
        List<Image> images = new ArrayList<Image>();
        for (UnsplashImage img : list) {
            Image image = new Image();

            image.setWidth(img.getWidth());
            image.setHeight(img.getHeight());
            image.setUsername(img.getUser().getUsername());
            image.setLikes(img.getLikes());
            image.setTags(img.getCategories());
            image.setUrl(img.getUrls().get(1));

            images.add(image);
        }
        LOGGER.info("Convert from UnsplashImage class to default Image class.");
        return images;
    }

    public static List<Image> convertImageFromPixabay(PixabayJsonResponse response) {
        List<Image> images = new ArrayList<Image>();
        for (PixabayImage img : response.getHits()) {
            Image image = new Image();

            image.setLikes(img.getLikes());
            image.setUsername(img.getUser());
            image.setTags(Arrays.asList(img.getTags().split(",")));
            //w, h, url - не понятно откуда брать инфу...

            images.add(image);
        }
        LOGGER.info("Convert from PixabayJsonResponse class to default Image class.");
        return images;
    }

    public static List<Image> convertImageFromPexels(PexelsJsonResponse response) {
        List<Image> images = new ArrayList<Image>();
        for (PexelsImage img : response.getPhotos()) {
            Image image = new Image();

            image.setWidth((int) img.getWidth());
            image.setHeight((int) img.getHeight());
            image.setUsername(img.getPhotographer());
            image.setUrl(img.getSrc().getOriginal()); //default URL or URL from src?
            image.setTags(new ArrayList<String>()); //set empty list or nothing?
            image.setLikes(0); //set 0 or nothing?

            images.add(image);
        }
        LOGGER.info("Convert from PexelsJsonResponse class to default Image class.");
        return images;
    }
}
