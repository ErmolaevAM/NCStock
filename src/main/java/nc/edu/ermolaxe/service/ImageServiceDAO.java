package nc.edu.ermolaxe.service;

import com.google.gson.Gson;
import nc.edu.ermolaxe.model.Image;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

/**
 * Created by Александр on 31.05.2017.
 */
public interface ImageServiceDAO {
    List<Image> getImageList(int listSize) throws IOException;
}
