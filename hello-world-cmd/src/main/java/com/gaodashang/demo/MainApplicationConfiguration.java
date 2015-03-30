package com.gaodashang.demo;

/**
 * Created by eva on 2015/3/7.
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class MainApplicationConfiguration implements CommandLineRunner {

    private Log logger = LogFactory.getLog(getClass());

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainApplicationConfiguration.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Override
    public void run(String... args) throws Exception {
        String url = "https://github.com/signup_check/username";
        Map<String, String> map = new HashMap<String, String>(1);
        map.put("value", "username");
        ResponseEntity<String> result = restTemplate().postForEntity(url, null, String.class, map);
        String resultStr = result.getBody();
        logger.debug("result:" + resultStr);
    }
}
