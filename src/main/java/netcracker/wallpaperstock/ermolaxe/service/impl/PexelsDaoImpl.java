package netcracker.wallpaperstock.ermolaxe.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import netcracker.wallpaperstock.ermolaxe.model.Image;
import netcracker.wallpaperstock.ermolaxe.model.pexels.model.PexelsJsonResponse;
import netcracker.wallpaperstock.ermolaxe.service.ImageServiceDAO;
import netcracker.wallpaperstock.ermolaxe.utils.ImageConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Александр on 13.06.2017.
 */
@Service
public class PexelsDaoImpl implements ImageServiceDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(PexelsDaoImpl.class);
    private static final String onePageUrl = "";

    private ObjectMapper objectMapper = new ObjectMapper();

    public PexelsDaoImpl() {
    }

    public List<Image> getImageList() {
        LOGGER.info("WallpaperStock: User requested a list of new photos from Pexels service.");
        List<Image> result = new ArrayList<Image>();

        try {
            PexelsJsonResponse response = objectMapper.readValue(new URL(onePageUrl), PexelsJsonResponse.class);

            result = ImageConverter.convertImageFromPexels(response);

            LOGGER.info("WallpaperStock: The list of photos has been successfully received from Pexels.");
        } catch (IOException ex) {
            StringBuilder msg = new StringBuilder();
            msg.append("WallpaperStock: Something went wrong! With message: [").append(ex.getMessage()).append("] and stacktrace [").append(ex.getStackTrace()).append("]");
            LOGGER.error(msg.toString(), Level.ERROR);
        }
        return result;
    }

    public List<Image> getPhotoByTag(String tag, int count) {
        return null;
    }
}
