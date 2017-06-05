package nc.edu.ermolaxe.service.impl;

import nc.edu.ermolaxe.model.Image;
import nc.edu.ermolaxe.model.unsplash.model.UnsplashImage;
import nc.edu.ermolaxe.utils.ImageConverter;
import nc.edu.ermolaxe.service.ImageServiceDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class UnsplashDaoImpl implements ImageServiceDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(UnsplashDaoImpl.class);
    private static final String onePageUrl = "https://api.unsplash.com/photos/?client_id=17ffc1d2fd01e2390b5e69a6ae6a970d1299966a33d4baa56f61f3816265b64f&?page=1";

    @Autowired
    private ObjectMapper objectMapper;

    public UnsplashDaoImpl() {
    }

    public List<Image> getImageList(int listSize) throws IOException {
        LOGGER.info("User requested a list of new photos.");
        List<Image> result = new ArrayList<Image>();
        try {
            List<UnsplashImage> imgList= objectMapper.readValue(new URL(onePageUrl),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, UnsplashImage.class));

            result = ImageConverter.convertImageFromUnsplash(imgList);

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

    @Bean
    private ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
}
