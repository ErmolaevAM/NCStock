package netcracker.wallpaperstock.ermolaxe.controller;

import netcracker.wallpaperstock.ermolaxe.model.Image;
import netcracker.wallpaperstock.ermolaxe.service.ImageServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Александр on 13.06.2017.
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    @Qualifier("unsplash")
    private ImageServiceDAO unsplashService;

    @Autowired
    @Qualifier("pixabay")
    private ImageServiceDAO pixabayService;

    @Autowired
    @Qualifier("fullservice")
    private ImageServiceDAO fullService;

    @Scheduled(cron = "0 0 0 * * *")
    @RequestMapping(value = "/photos", method = RequestMethod.GET)
    private @ResponseBody List<Image> getPhotots() {
        return fullService.getImageList();
    }

    @RequestMapping(value = "/photosbytag", method = RequestMethod.GET)
    private @ResponseBody List<Image> getByTag(@RequestParam(value = "tag")String tag) {
        return fullService.getPhotoByTag(tag, 1);
    }


//    test methods
    @RequestMapping(value = "/unsplash", method = RequestMethod.GET)
    public @ResponseBody List<Image> getUnsplashImage() {
        return unsplashService.getImageList();
    }

    @RequestMapping(value = "/pixabay", method = RequestMethod.GET)
    public @ResponseBody List<Image> getPixabayImage() {
        return pixabayService.getImageList();
    }


}
