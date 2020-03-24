package com.example.first.service.impl;

import com.example.first.entity.Goods;
import com.example.first.service.IDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyu<zhangyu @ cecdat.com>
 * @version v0.1 2020/3/20
 * @class <code>DemoServiceImpl</code>
 * @see
 * @since JDK1.8
 */
@Service
@Slf4j
public class DemoServiceImpl implements IDemoService {
    private static final Map<Long, Goods> ITEM_MAP = new HashMap<Long, Goods>();
    static {
        ITEM_MAP.put(1L, new Goods(1L,"商品A",1.0f));
    }
    @Override
    public Goods getGoods(Long id) {
        log.info("收到获取商品信息请求，id:{}",id);
        return ITEM_MAP.get(id);
    }
}
