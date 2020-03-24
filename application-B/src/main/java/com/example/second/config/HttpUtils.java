package com.example.second.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
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
