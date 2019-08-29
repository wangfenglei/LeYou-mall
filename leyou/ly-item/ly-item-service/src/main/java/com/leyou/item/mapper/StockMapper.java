package com.leyou.item.mapper;

import com.leyou.pojo.Stock;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author wfl
 * @description
 */
public interface StockMapper extends Mapper<Stock> , IdListMapper<Stock, Long>, InsertListMapper<Stock> {

    @Insert("insert into tb_stock (sku_id,stock) values(#{skuId},#{stock})")
    int insertStock(Stock stock);

    @Update("UPDATE tb_stock SET stock = stock - #{num} WHERE sku_id = #{id} AND stock >= #{num}")
    int decreaseStock(@Param("id") Long id, @Param("num") Integer num);
}
