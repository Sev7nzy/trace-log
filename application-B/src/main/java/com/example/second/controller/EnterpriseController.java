package com.example.second.controller;

import com.example.second.service.IEnterpriseService;
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
@RequestMapping(value = "/V2.0/enterprise")
@Slf4j
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class EnterpriseController {
    @Autowired
    IEnterpriseService enterpriseService;

    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getGoods(@PathVariable Long id) {
        log.info("下发获取商品信息请求，id:{}",id);

        String response = (String) restTemplate.exchange("http://localhost:8085/V2.0/item/"+id,
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
                }).getBody();
        return response;
    }

    @RequestMapping(value = "/mdc/{id}",method = RequestMethod.GET)
    public String getGoodsMdc(@PathVariable Long id){
        return enterpriseService.getGoods(id);
    }

}
