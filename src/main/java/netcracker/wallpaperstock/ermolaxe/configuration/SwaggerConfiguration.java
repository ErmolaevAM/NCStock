package netcracker.wallpaperstock.ermolaxe.configuration;

import netcracker.wallpaperstock.ermolaxe.controller.RestController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by Александр on 18.06.2017.
 */
@Configuration
@EnableSwagger2
@ComponentScan(basePackageClasses = RestController.class)
public class SwaggerConfiguration {

    private static final String SWAGGER_API_VERSION = "1.0";
    private static final String title = "WallpaperStock API. Receiving photos.";
    private static final String description = "The module for receiving photos from third-party services.";


    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .version(SWAGGER_API_VERSION)
                .build();
    }

    @Bean
    public Docket usersApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")
                .select()
                .paths(PathSelectors.regex("/imageservice.*"))
                .build();
    }



}
