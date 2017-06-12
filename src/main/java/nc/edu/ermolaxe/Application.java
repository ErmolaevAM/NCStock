package nc.edu.ermolaxe;

import nc.edu.ermolaxe.service.ImageServiceDAO;
import nc.edu.ermolaxe.service.impl.UnsplashDaoImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;


/**
 * Created by Александр on 19.05.2017.
 */
@ComponentScan
@EnableAutoConfiguration
@EnableScheduling
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
