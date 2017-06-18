package netcracker.wallpaperstock.ermolaxe.service.impl;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import netcracker.wallpaperstock.ermolaxe.model.Image;
import netcracker.wallpaperstock.ermolaxe.model.pixabay.model.PixabayJsonResponse;
import netcracker.wallpaperstock.ermolaxe.service.ImageServiceDAO;
import netcracker.wallpaperstock.ermolaxe.utils.CategoryReaderFromFile;
import netcracker.wallpaperstock.ermolaxe.utils.ImageConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Александр on 13.06.2017.
 */
@Service
public class PixabayDaoImpl implements ImageServiceDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(PixabayDaoImpl.class);
    private static final String onePageUrl = "https://pixabay.com/api/?key=5607958-00884c51bf718500bfe2f5c53&page=1&per_page=100";
    //вопрос: как быть со страницей? Можно брать рандомное число при каждом новом запросе в качестве страницы (как не выйти за границы кол-ва всех страниц)?

    private static final String categoryPageUrl = "https://pixabay.com/api/?key=5607958-00884c51bf718500bfe2f5c53&page=1&per_page=100&category=";
    /*Accepted values: fashion, nature, backgrounds, science, education, people, feelings, religion, health,
     places, animals, industry, food, computer, sports, transportation, travel, buildings, business, music*/

    private List<String> pixabayCategory;

    private ObjectMapper objectMapper = new ObjectMapper();

    public PixabayDaoImpl() {
        pixabayCategory = CategoryReaderFromFile.readCateforyFromFileToArray("D:\\ermolaxe\\IdeaProjects\\homedev.spring\\WallpaperStock\\src\\main\\resources\\pixabayCategory.txt");
    }

    public List<Image> getImageList() {
        LOGGER.info("WallpaperStock: User requested a list of new photos from Pixabay service.");
        List<Image> result = new ArrayList<Image>();

        try {
            LOGGER.warn("0");

            PixabayJsonResponse response = objectMapper.readValue(new URL(onePageUrl), PixabayJsonResponse.class);
            LOGGER.warn("1");
            result = ImageConverter.convertImageFromPixabay(response);

            LOGGER.info("WallpaperStock: The list of photos has been successfully received from Pixabay.");
        } catch (MalformedURLException ex) {
            StringBuilder msg = new StringBuilder();
            msg.append("WallpaperStock: Something went wrong! With message: [").append(ex.getMessage()).append("] and stacktrace [").append(ex.getStackTrace()).append("]");
            LOGGER.error(msg.toString(), Level.ERROR);
        } catch (JsonParseException ex) {
            StringBuilder msg = new StringBuilder();
            msg.append("WallpaperStock: Something went wrong with Json file parse! With message: [").append(ex.getMessage()).append("] and stacktrace [").append(ex.getStackTrace()).append("]");
            LOGGER.error(msg.toString(), Level.ERROR);
        } catch (JsonMappingException ex) {
            StringBuilder msg = new StringBuilder();
            msg.append("WallpaperStock: Something went wrong with Json fields mapping! With message: [").append(ex.getMessage()).append("] and stacktrace [").append(ex.getStackTrace()).append("]");
            LOGGER.error(msg.toString(), Level.ERROR);
        } catch (IOException ex) {
            StringBuilder msg = new StringBuilder();
            msg.append("WallpaperStock: Something went wrong! With message: [").append(ex.getMessage()).append("] and stacktrace [").append(ex.getStackTrace()).append("]");
            LOGGER.error(msg.toString(), Level.ERROR);
        }
        return result;
    }

    public List<Image> getPhotoByTag(String tag, int count) {
        LOGGER.info("WallpaperStock: User requested a list of photos from Pixabay service with tag: "+tag);
        List<Image> result = new ArrayList<Image>();
        if (pixabayCategory.contains(tag)) {
            try {
                PixabayJsonResponse response = objectMapper.readValue(new URL(categoryPageUrl+tag), PixabayJsonResponse.class);
                result = ImageConverter.convertImageFromPixabay(response);

                LOGGER.info(String.format("WallpaperStock: The list of photos with tag %s has been successfully received from Pixabay.", tag));
            } catch (MalformedURLException ex) {
                StringBuilder msg = new StringBuilder();
                msg.append("WallpaperStock: Something went wrong! With message: [").append(ex.getMessage()).append("] and stacktrace [").append(ex.getStackTrace()).append("]");
                LOGGER.error(msg.toString(), Level.ERROR);
            } catch (JsonParseException ex) {
                StringBuilder msg = new StringBuilder();
                msg.append("WallpaperStock: Something went wrong with Json file parse! With message: [").append(ex.getMessage()).append("] and stacktrace [").append(ex.getStackTrace()).append("]");
                LOGGER.error(msg.toString(), Level.ERROR);
            } catch (JsonMappingException ex) {
                StringBuilder msg = new StringBuilder();
                msg.append("WallpaperStock: Something went wrong with Json fields mapping! With message: [").append(ex.getMessage()).append("] and stacktrace [").append(ex.getStackTrace()).append("]");
                LOGGER.error(msg.toString(), Level.ERROR);
            } catch (IOException ex) {
                StringBuilder msg = new StringBuilder();
                msg.append("WallpaperStock: Something went wrong! With message: [").append(ex.getMessage()).append("] and stacktrace [").append(ex.getStackTrace()).append("]");
                LOGGER.error(msg.toString(), Level.ERROR);
            }
        } else {
            LOGGER.warn(String.format("WallpaperStock: Category %s isn't found.", tag), Level.WARN);
        }
        return result;
    }


}
