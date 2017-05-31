package nc.edu.ermolaxe;

import com.google.gson.Gson;
import nc.edu.ermolaxe.model.Image;
import nc.edu.ermolaxe.service.ImageServiceDAO;
import nc.edu.ermolaxe.service.impl.UnsplashDaoImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

/**
 * Created by Александр on 19.05.2017.
 */
@ComponentScan
@EnableAutoConfiguration
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

/*        ImageServiceDAO dao = new UnsplashDaoImpl();

        try {
            Gson img = dao.getImageList(1);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
