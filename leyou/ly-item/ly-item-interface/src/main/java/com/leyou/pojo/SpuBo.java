package com.leyou.pojo;

import lombok.Data;

import javax.persistence.Transient;
import java.util.List;

/**
 * @author wfl
 * @description
 */

@Data
public class SpuBo extends Spu {

    @Transient
    String categoryName;// 商品分类名称
    @Transient
    String brandName;// 品牌名称

    @Transient
    SpuDetail spuDetail;// 商品详情
    @Transient
    List<Sku> skus;// sku列表


}