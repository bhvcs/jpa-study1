package jpaStudy.jpaShop.config;

import jpaStudy.jpaShop.web.ItemController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "jpaStudy.jpaShop.web")
public class ControllerConfig {
    public ItemController itemController(){
        return new ItemController();
    }
}
