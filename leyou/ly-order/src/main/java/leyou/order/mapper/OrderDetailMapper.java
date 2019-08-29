package leyou.order.mapper;


import leyou.order.pojo.OrderDetail;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

public interface OrderDetailMapper extends BaseMapper<OrderDetail>, InsertListMapper {
}
