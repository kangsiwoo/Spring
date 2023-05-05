package test.test.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Controller
public class controller
{
    @Configuration
    public class WebConfig implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/api/**")
                    .allowedOrigins("http://example.com")
                    .allowedMethods("GET", "POST")
                    .allowedHeaders("header1", "header2", "header3")
                    .allowCredentials(false)
                    .maxAge(3600);
        }
    }

    @CrossOrigin("*")
    @GetMapping("API")
    public String API(@RequestParam(value = "temp", required = false) String temp, Model model)
    {
        if(temp != null) {
            model.addAttribute("temp", temp);
            return "API";
        }else
        {
            model.addAttribute("temp", "empty");
            return "API";
        }
    }
}
