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
            return imageServiceDAO.getImageList();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    /*------test methods------*/
    @RequestMapping("/test")
    public @ResponseBody String test() {
        String str = new String("this is test JSON message");
        return str;
    }

}
