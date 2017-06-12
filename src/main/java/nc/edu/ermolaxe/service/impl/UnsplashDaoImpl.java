package nc.edu.ermolaxe.service.impl;

import nc.edu.ermolaxe.model.Image;
import nc.edu.ermolaxe.model.unsplash.model.UnsplashImage;
import nc.edu.ermolaxe.utils.ImageConverter;
import nc.edu.ermolaxe.service.ImageServiceDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class UnsplashDaoImpl implements ImageServiceDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(UnsplashDaoImpl.class);
    private static final String onePageUrl = "https://api.unsplash.com/photos/?client_id=17ffc1d2fd01e2390b5e69a6ae6a970d1299966a33d4baa56f61f3816265b64f&page=1&per_page=100";
    //вопрос: как быть со страницей? Можно брать рандомное число при каждом новом запросе в качестве страницы (как не выйти за границы кол-ва всех страниц)?

    private ObjectMapper objectMapper = new ObjectMapper();

    public UnsplashDaoImpl() {
    }

    public List<Image> getImageList() throws IOException {
        LOGGER.info("User requested a list of new photos.");
        List<Image> result = new ArrayList<Image>();
        try {
            List<UnsplashImage> imgList= objectMapper.readValue(new URL(onePageUrl),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, UnsplashImage.class));

            result = ImageConverter.convertImageFromUnsplash(imgList);

            LOGGER.info("The list of photos has been successfully received.");
        } catch (IOException ex) {
            StringBuilder msg = new StringBuilder();
            msg.append("Something went wrong! With message: [").append(ex.getMessage()).append("] and stacktrace [").append(ex.getStackTrace()).append("]");
            LOGGER.error(msg.toString(), Level.ERROR);
        }
        return result;
    }

    public List<Image> getPhotoByTag(String tag) {

        /*поиск по коллекции осуществляется так, нужно получить id коллекции по запросу типа:
        * GET /search/collections?query=terms
        * потом запросить фотографии из коллекции по запросу типа:
        * GET /collections/:id/photos?page=number&per_page=count*/

        return null;
    }

}
