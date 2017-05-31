package nc.edu.ermolaxe.service.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.google.gson.Gson;
import nc.edu.ermolaxe.model.Image;
import nc.edu.ermolaxe.model.unsplash.model.UnsplashImage;
import nc.edu.ermolaxe.service.ImageMapper;
import nc.edu.ermolaxe.service.ImageServiceDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Александр on 31.05.2017.
 */
@Service
public class UnsplashDaoImpl implements ImageServiceDAO {

    public UnsplashDaoImpl() {
        System.out.println("---LOG: unsplash dao impl constructor");
    }

    public List<Image> getImageList(int listSize) throws IOException {
        System.out.println("---LOG from getImageList: start method");
        String url = "https://api.unsplash.com/photos/?client_id=17ffc1d2fd01e2390b5e69a6ae6a970d1299966a33d4baa56f61f3816265b64f&?page=1";
        ObjectMapper mapper = new ObjectMapper();
        List<Image> result = new ArrayList<Image>();
//        mapper.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
        try {
            List<UnsplashImage> imgList= mapper.readValue(new URL(url), mapper.getTypeFactory().constructCollectionType(List.class, UnsplashImage.class));
            result = ImageMapper.change(imgList);
            for (Image item : result) {
                System.out.println(item.toString());
            }
        } catch (IOException ex) {
            ex.getMessage();
            ex.printStackTrace();
        }
        return result;
    }
}
