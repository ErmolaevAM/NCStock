package netcracker.wallpaperstock.ermolaxe.service.impl;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import netcracker.wallpaperstock.ermolaxe.model.Image;
import netcracker.wallpaperstock.ermolaxe.model.unsplash.model.UnsplashImage;
import netcracker.wallpaperstock.ermolaxe.model.unsplash.model.UnsplashJsonResponse;
import netcracker.wallpaperstock.ermolaxe.service.ImageServiceDAO;
import netcracker.wallpaperstock.ermolaxe.utils.ImageConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Александр on 13.06.2017.
 */
@Service
public class UnsplashDaoImpl implements ImageServiceDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(UnsplashDaoImpl.class);
    private static final String onePageUrl = "https://api.unsplash.com/photos/?client_id=17ffc1d2fd01e2390b5e69a6ae6a970d1299966a33d4baa56f61f3816265b64f&page=1&per_page=100";
    //вопрос: как быть со страницей? Можно брать рандомное число при каждом новом запросе в качестве страницы (как не выйти за границы кол-ва всех страниц)?
    private static final String photoByCategory = "https://api.unsplash.com/search/photos?client_id=17ffc1d2fd01e2390b5e69a6ae6a970d1299966a33d4baa56f61f3816265b64f&page=1&per_page=%d&query=&s";

    private ObjectMapper objectMapper = new ObjectMapper();

    public UnsplashDaoImpl() {
    }

    public List<Image> getImageList() {
        LOGGER.info("WallpaperStock: User requested a list of new photos from Unsplash service.");
        List<Image> result = new ArrayList<Image>();
        try {
            List<UnsplashImage> imgList = objectMapper.readValue(new URL(onePageUrl),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, UnsplashImage.class));

            result = ImageConverter.convertImageFromUnsplash(imgList);

            LOGGER.info("WallpaperStock: The list of photos has been successfully received from Unsplash.");
        } catch (IOException ex) {
            StringBuilder msg = new StringBuilder();
            msg.append("WallpaperStock: Something went wrong! With message: [").append(ex.getMessage()).append("] and stacktrace [").append(ex.getStackTrace()).append("]");
            LOGGER.error(msg.toString(), Level.ERROR);
        }
        return result;
    }

    public List<Image> getPhotoByTag(String tag, int count) {
        LOGGER.info("WallpaperStock: User requested a list of photos from Unsplash service with tag: "+tag);
        List<Image> result = new ArrayList<>();
        try {
            String fullUrl = String.format(photoByCategory,count,tag);
            UnsplashJsonResponse unsplashJsonResponse = objectMapper.readValue(new URL(fullUrl), UnsplashJsonResponse.class);

            result = ImageConverter.convertImageFromUnsplash(unsplashJsonResponse.getResults());

            LOGGER.info(String.format("WallpaperStock: The list of photos with tag %s has been successfully received from Unsplash.", tag));
        } catch (MalformedURLException ex) {
            StringBuilder msg = new StringBuilder();
            msg.append("WallpaperStock: Something went wrong! With message: [").append(ex.getMessage()).append("] and stacktrace [").append(ex.getStackTrace()).append("]");
            LOGGER.error(msg.toString(), Level.ERROR);
        } catch (JsonParseException ex) {
            StringBuilder msg = new StringBuilder();
            msg.append("WallpaperStock: Something went wrong with Json file parse! With message: [").append(ex.getMessage()).append("] and stacktrace [").append(ex.getStackTrace()).append("]");
            LOGGER.error(msg.toString(), Level.ERROR);
        } catch (JsonMappingException ex) {
            StringBuilder msg = new StringBuilder();
            msg.append("WallpaperStock: Something went wrong with Json fields mapping! With message: [").append(ex.getMessage()).append("] and stacktrace [").append(ex.getStackTrace()).append("]");
            LOGGER.error(msg.toString(), Level.ERROR);
        } catch (IOException ex) {
            StringBuilder msg = new StringBuilder();
            msg.append("WallpaperStock: Something went wrong! With message: [").append(ex.getMessage()).append("] and stacktrace [").append(ex.getStackTrace()).append("]");
            LOGGER.error(msg.toString(), Level.ERROR);
        }

        return result;
    }
}
