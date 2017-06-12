package nc.edu.ermolaxe.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import nc.edu.ermolaxe.model.Image;
import nc.edu.ermolaxe.model.pexels.model.PexelsJsonResponse;
import nc.edu.ermolaxe.service.ImageServiceDAO;
import nc.edu.ermolaxe.utils.ImageConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Александр on 12.06.2017.
 */
@Service
public class PexelsDaoImpl implements ImageServiceDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(PexelsDaoImpl.class);
    private static final String onePageUrl = "";

    private ObjectMapper objectMapper = new ObjectMapper();

    public PexelsDaoImpl() {
    }

    public List<Image> getImageList() throws IOException {
        LOGGER.info("User requested a list of new photos.");
        List<Image> result = new ArrayList<Image>();
        try {
            PexelsJsonResponse pexelsJsonResponse = objectMapper.readValue(new URL(onePageUrl),PexelsJsonResponse.class);

            result = ImageConverter.convertImageFromPexels(pexelsJsonResponse);

            LOGGER.info("The list of photos has been successfully received.");
        } catch (IOException ex) {
            StringBuilder msg = new StringBuilder();
            msg.append("Something went wrong! With message: [").append(ex.getMessage()).append("] and stacktrace [").append(ex.getStackTrace()).append("]");
            LOGGER.error(msg.toString(), Level.ERROR);
        }
        return result;
    }

    public List<Image> getPhotoByTag(String tag) {
        return null;
    }
}
