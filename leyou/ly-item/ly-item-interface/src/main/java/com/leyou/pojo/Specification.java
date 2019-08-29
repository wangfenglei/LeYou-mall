package com.leyou.pojo;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wfl
 * @description
 */
@Table(name = "tb_specification")
public class Specification {

    @Id
    private Long categoryId;    //商品id
    private String specifications;   //分组信息

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }
}