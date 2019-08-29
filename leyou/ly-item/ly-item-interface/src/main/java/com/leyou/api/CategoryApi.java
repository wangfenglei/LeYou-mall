package com.leyou.api;

import com.leyou.pojo.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author wfl
 * @description
 */


@RequestMapping("category")
public interface CategoryApi {

    /**
     * 根据id查询商品分类
     * @param ids
     */
    @GetMapping("list/ids")
    List<Category> queryCategoryListByids(@RequestParam("ids") List<Long> ids);

    /**
     * 根据3级分类id，查询1~3级的分类
     * @param id
     * @return
     */
    @GetMapping("all/level")
    public List<Category> queryAllByCid3(@RequestParam("id") Long id);

}
