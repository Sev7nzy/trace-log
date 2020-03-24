package com.example.second.service.impl;

import com.example.second.config.HttpUtils;
import com.example.second.service.IEnterpriseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author zhangyu<zhangyu @ cecdat.com>
 * @version v0.1 2020/3/23
 * @class <code>CustomerServiceImpl</code>
 * @see
 * @since JDK1.8
 */
@Slf4j
@Service
public class EnterpriseServiceImpl implements IEnterpriseService {
    @Value("${spring.application.name:app-B}")
    String appName;

    @Override
    public String getGoods(Long id) {
        String result = null;
        try {
            String url = "http://localhost:8085/V2.0/item/"+id;
            result = HttpUtils.get(url,appName);
            log.info("发送获取商品请求");
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
