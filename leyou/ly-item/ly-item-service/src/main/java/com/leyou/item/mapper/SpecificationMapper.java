package com.leyou.item.mapper;

import com.leyou.pojo.Specification;
import org.apache.ibatis.annotations.Delete;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author wfl
 * @description
 */
public interface SpecificationMapper extends Mapper<Specification> {

    /**
     * 删除参数
     * @param id
     */
    @Delete("delete from tb_specification where category_id = #{id}")
    public void deleteSpec(Long id);
}
