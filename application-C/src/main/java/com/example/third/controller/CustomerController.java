package com.example.third.controller;

import com.example.third.service.ICustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhangyu<zhangyu @ cecdat.com>
 * @version v0.1 2020/3/23
 * @class <code>CustomerController</code>
 * @see
 * @since JDK1.8
 */
@RequestMapping(value = "/V2.0/customer")
@Slf4j
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getGoods(@PathVariable Long id) {
        log.info("下发获取商品请求，id:{}",id);
        String response = (String) restTemplate.exchange("http://localhost:8086/V2.0/enterprise/"+id,
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}).getBody();
        return response;
    }

    @RequestMapping(value="/mdc/{id}")
    public String zipkinService1(@PathVariable Long id)
    {
        return customerService.getGoods(id);
    }

}
