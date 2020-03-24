package com.example.first.service;

import com.example.first.entity.Goods;

/**
 * @author zhangyu<zhangyu @ cecdat.com>
 * @version v0.1 2020/3/20
 * @class <code>IDemoService</code>
 * @see
 * @since JDK1.8
 */
public interface IDemoService {
    Goods getGoods(Long id);
}
