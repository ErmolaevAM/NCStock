package nc.edu.ermolaxe.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import nc.edu.ermolaxe.model.Image;
import nc.edu.ermolaxe.model.pixabay.model.PixabayJsonResponse;
import nc.edu.ermolaxe.model.unsplash.model.UnsplashImage;
import nc.edu.ermolaxe.service.ImageServiceDAO;
import nc.edu.ermolaxe.utils.ImageConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Александр on 11.06.2017.
 */
public class PixabayDaoImpl implements ImageServiceDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(PixabayDaoImpl.class);
    private static final String onePageUrl = "https://pixabay.com/api/?key=5607958-00884c51bf718500bfe2f5c53&page=1&per_page=100";
    //вопрос: как быть со страницей? Можно брать рандомное число при каждом новом запросе в качестве страницы (как не выйти за границы кол-ва всех страниц)?

    private ObjectMapper objectMapper = new ObjectMapper();

    public PixabayDaoImpl() {
    }

    public List<Image> getImageList() throws IOException {
        LOGGER.info("User requested a list of new photos.");
        List<Image> result = new ArrayList<Image>();
        try {
            PixabayJsonResponse pixabayJsonResponse = objectMapper.readValue(new URL(onePageUrl), PixabayJsonResponse.class);

            result = ImageConverter.convertImageFromPixabay(pixabayJsonResponse);

            /*------test------*/
            for (Image item : result) {
                System.out.println(item.toString());
            }
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
