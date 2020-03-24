package com.example.first.entity;

import lombok.Data;

/**
 * @author zhangyu<zhangyu @ cecdat.com>
 * @version v0.1 2020/3/20
 * @class <code>Goods</code>
 * @see
 * @since JDK1.8
 */
@Data
public class Goods {
    private String goodName;
    private Long goodNo;
    private Float price;

    public Goods(Long goodNo,String goodName,Float price){
        this.goodNo=goodNo;
        this.goodName=goodName;
        this.price=price;
    }
}
