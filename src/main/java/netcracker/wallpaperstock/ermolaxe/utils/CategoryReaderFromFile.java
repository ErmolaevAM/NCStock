package netcracker.wallpaperstock.ermolaxe.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Александр on 14.06.2017.
 */
public class CategoryReaderFromFile {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryReaderFromFile.class);

    public static List<String> readCateforyFromFileToArray(String path) {
        List<String> tmp = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            String s;
            while ((s = in.readLine())!=null) {
                for (String item : s.split(", ")) {
                    tmp.add(item);
                }
            }
        } catch (FileNotFoundException e) {
            StringBuilder msg = new StringBuilder();
            msg.append("WallpaperStock: File with path [").append(path).append("] isn't found.");
            LOGGER.error(msg.toString(), Level.ERROR);
        } catch (IOException ex) {
            StringBuilder msg = new StringBuilder();
            msg.append("WallpaperStock: Something went wrong! With message: [").append(ex.getMessage()).append("] and stacktrace [").append(ex.getStackTrace()).append("]");
            LOGGER.error(msg.toString(), Level.ERROR);
        }
        return tmp;
    }

}
