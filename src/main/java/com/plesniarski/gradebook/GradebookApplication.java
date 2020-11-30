package com.plesniarski.gradebook;

import com.plesniarski.gradebook.authentication.JwtFilter;
import com.plesniarski.gradebook.swagger.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableAsync
@Import(SwaggerConfig.class)
public class GradebookApplication {

    public static void main(String[] args) {
        SpringApplication.run(GradebookApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new JwtFilter());
        filterRegistrationBean.addUrlPatterns(
                "/grades/addGrade");
        return filterRegistrationBean;
    }

}
