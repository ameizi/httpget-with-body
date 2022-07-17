package com.example.anchnet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Slf4j
@SpringBootApplication
public class AnchnetApplication {

    @Resource
    private RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(AnchnetApplication.class, args);
    }


    public ResponseEntity<Object> createCodeByNumber(String url) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key", "key");
        jsonObject.put("secret", "secret");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(JSON.toJSONString(jsonObject), headers);
        log.info("url:" + url + ",httpEntity:" + JSON.toJSONString(entity));
        ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.GET, entity, Object.class);
        log.info("{}请求的返回内容:{}", url, JSON.parseObject(JSON.toJSONString(response.getBody())));
        return response;
    }

}
