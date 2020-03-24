package com.example.third.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * @author zhangyu<zhangyu @ cecdat.com>
 * @version v0.1 2020/3/23
 * @class <code>HttpUtils</code>
 * @see
 * @since JDK1.8
 */
@Slf4j
public class HttpUtils {

    public static String get(String url,String appName) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("traceId", MDC.get("traceId"));
        headers.add("parentApp",appName);
        System.out.println(appName);
        URI uri = new URI(url);
        RequestEntity<?> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, uri);
        ResponseEntity<String> exchange = restTemplate.exchange(requestEntity, String.class);

        if (exchange.getStatusCode().equals(HttpStatus.OK)) {
            log.info("send http request success");
        }

        return exchange.getBody();
    }
}
