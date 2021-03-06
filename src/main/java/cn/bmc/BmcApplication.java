package cn.bmc;

import cn.bmc.controller.web.JSCrossDomainFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

//@RestController
@SpringBootApplication
//@EnableCaching
public class BmcApplication {

    public static void main(String[] args) {
        SpringApplication.run(BmcApplication.class, args);
    }

    /*@RequestMapping(value = "/", produces = "text/plain;charset=UTF-8")
    public String index() {
        return "Hello Spring Boot!";
    }

    @Bean
    public FilterRegistrationBean securityFilter() {
        JSCrossDomainFilter filter = new JSCrossDomainFilter();
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(filter);
        registration.addUrlPatterns("/*");
        registration.setName("JSCrossDomainFilter");
        return registration;
    }*/

    //跨域请求解决
    @Configuration
    public class WebConfig implements WebMvcConfigurer {

        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedOrigins("*")
                    .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                    .maxAge(3600)
                    .allowCredentials(true);
        }
    }

}
