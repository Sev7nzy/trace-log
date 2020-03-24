package com.example.first.controller;

import com.example.first.entity.Goods;
import com.example.first.service.IDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhangyu<zhangyu @ cecdat.com>
 * @version v0.1 2020/3/20
 * @class <code>DemoController</code>
 * @see
 * @since JDK1.8
 */
@RequestMapping(value = "/V2.0/item")
@Slf4j
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class DemoController {

    @Autowired
    IDemoService demoService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Goods getGoods(@PathVariable Long id) {
        return demoService.getGoods(id);
    }
}
