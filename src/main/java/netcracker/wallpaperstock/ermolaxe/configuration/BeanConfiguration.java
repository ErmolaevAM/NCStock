package netcracker.wallpaperstock.ermolaxe.configuration;

import netcracker.wallpaperstock.ermolaxe.service.ImageServiceDAO;
import netcracker.wallpaperstock.ermolaxe.service.impl.FullServiceDaoImpl;
import netcracker.wallpaperstock.ermolaxe.service.impl.PixabayDaoImpl;
import netcracker.wallpaperstock.ermolaxe.service.impl.UnsplashDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Александр on 13.06.2017.
 */
@Configuration
public class BeanConfiguration {

    @Bean(name = "unsplash")
    public ImageServiceDAO unsplash() {
        return new UnsplashDaoImpl();
    }

    @Bean(name = "pixabay")
    public ImageServiceDAO pixabay() {
        return new PixabayDaoImpl();
    }

    @Bean(name = "fullservice")
    public ImageServiceDAO fullService() {
        return new FullServiceDaoImpl();
    }
}

