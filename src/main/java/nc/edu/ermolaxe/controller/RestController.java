package nc.edu.ermolaxe.controller;

import nc.edu.ermolaxe.model.Image;
import nc.edu.ermolaxe.service.ImageServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private ImageServiceDAO imageServiceDAO;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody List<Image> info() {
        try {
            return imageServiceDAO.getImageList(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Image> images = new ArrayList<Image>();
        Image img = new Image();
        img.setId("-1");
        img.setUrls(new ArrayList<String>());
        return images;
    }

    @RequestMapping("/test")
    public @ResponseBody String test() {
        String str = new String("this is test JSON message");
        return str;
    }

    @RequestMapping("/one")
    public @ResponseBody Image one() {
        List<String> urls = new ArrayList<String>();
        urls.add("https://ermolaxe/image/143");
        return new Image("43", urls);
    }


}
