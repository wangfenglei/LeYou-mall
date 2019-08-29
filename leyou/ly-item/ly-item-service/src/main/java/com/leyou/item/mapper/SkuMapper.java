package com.leyou.item.mapper;

import com.leyou.pojo.Sku;
import com.leyou.pojo.Stock;
import org.apache.ibatis.annotations.Insert;
import tk.mybatis.mapper.additional.idlist.SelectByIdListMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author wfl
 * @description
 */
public interface SkuMapper extends Mapper<Sku> , SelectByIdListMapper<Sku,Long> {


}
