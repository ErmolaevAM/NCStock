package netcracker.wallpaperstock.ermolaxe.service.impl;

import netcracker.wallpaperstock.ermolaxe.model.Image;
import netcracker.wallpaperstock.ermolaxe.service.ImageServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Александр on 16.06.2017.
 */
@Service
public class FullServiceDaoImpl implements ImageServiceDAO {


    @Autowired
    @Qualifier("unsplash")
    private ImageServiceDAO unsplashService;

    @Autowired
    @Qualifier("pixabay")
    private ImageServiceDAO pixabayService;


    @Override
    public List<Image> getImageList() {
        List<Image> result = unsplashService.getImageList();
        for (Image item : pixabayService.getImageList()) {
            result.add(item);
        }
        return result;
    }

    @Override
    public List<Image> getPhotoByTag(String tag, int count) {
        //надо ходить в базу и искать там фотки и если их меньше 30 то искать в сервисах
        return null;
    }
}
