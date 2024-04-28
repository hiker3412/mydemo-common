package io.example.common.model.bean;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GsonBeanConfig {

    @Bean
    public Gson gson() {
        return new Gson();
    }
}
