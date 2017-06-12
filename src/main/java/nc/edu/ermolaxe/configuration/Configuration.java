package nc.edu.ermolaxe.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import nc.edu.ermolaxe.service.impl.PexelsDaoImpl;
import nc.edu.ermolaxe.service.impl.PixabayDaoImpl;
import nc.edu.ermolaxe.service.impl.UnsplashDaoImpl;
import org.springframework.context.annotation.Bean;

/**
 * Created by Александр on 12.06.2017.
 */
@org.springframework.context.annotation.Configuration
public class Configuration {


    @Bean(name = "unsplash")
    public UnsplashDaoImpl getUnsplashDao(){
        return new UnsplashDaoImpl();
    }

    @Bean(name = "pixabay")
    public PixabayDaoImpl getPixabayDao(){
        return new PixabayDaoImpl();
    }

    @Bean(name = "pexels")
    public PexelsDaoImpl getPexelsDao() {
        return new PexelsDaoImpl();
    }

    @Bean(name = "jacksonMapper")
    public ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }

}
