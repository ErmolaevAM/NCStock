package nc.edu.ermolaxe.service;

import nc.edu.ermolaxe.model.Image;

import java.io.IOException;
import java.util.List;

/**
 * Created by Александр on 31.05.2017.
 */
public interface ImageServiceDAO {
    List<Image> getImageList(int listSize) throws IOException;
}
