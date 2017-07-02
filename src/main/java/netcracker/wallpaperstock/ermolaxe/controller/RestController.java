package netcracker.wallpaperstock.ermolaxe.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import netcracker.wallpaperstock.ermolaxe.model.Image;
import netcracker.wallpaperstock.ermolaxe.service.ImageServiceDAO;
import netcracker.wallpaperstock.ermolaxe.service.impl.UnsplashDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
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
@RequestMapping("/imageservice")
@Api(value = "Main REST Controller", produces = MediaType.APPLICATION_JSON_VALUE)
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

    @ApiOperation("Get photo from all services.")
    @ApiResponse(code = 200, message = "Photos from all service was downloaded.", response = List.class)
    @Scheduled(cron = "0 0 0 * * *")
    @RequestMapping(value = "/photos", method = RequestMethod.GET)
    private @ResponseBody
    List<Image> getPhotots() {
        return fullService.getImageList();
    }

    @ApiOperation("Get photo by tag.")
    @ApiResponse(code = 200, message = "Photos by tag was downloaded.", response = List.class)
    @RequestMapping(value = "/photosbytag", method = RequestMethod.GET)
    private @ResponseBody
    List<Image> getByTag(@RequestParam(value = "tag") String tag) {
        return fullService.getPhotoByTag(tag, 1);
    }


    //    test methods
    @ApiOperation("Get photo from Unsplash service only.")
    @ApiResponse(code = 200, message = "Photos from Unsplash service was downloaded.", response = List.class)
    @RequestMapping(value = "/unsplash", method = RequestMethod.GET)
    public @ResponseBody
    List<Image> getUnsplashImage() {
        return unsplashService.getImageList();
    }

    @ApiOperation("Get photo from Pixabay service only.")
    @ApiResponse(code = 200, message = "Photos from Pixabay service was downloaded.", response = List.class)
    @RequestMapping(value = "/pixabay", method = RequestMethod.GET)
    public @ResponseBody
    List<Image> getPixabayImage() {
        return pixabayService.getImageList();
    }

    @ApiOperation("Start page for tests.")
    @ApiResponse(code = 200, message = "Hello world!", response = String.class)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody
    String startPage() {
        return "Hello world!";
    }

}
