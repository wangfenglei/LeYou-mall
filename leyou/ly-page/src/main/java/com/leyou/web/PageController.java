package com.leyou.web;


import com.leyou.service.FileService;
import com.leyou.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;


@Controller
@RequestMapping("item")
public class PageController {
    @Autowired
    PageService pageService;
    @Autowired
    FileService fileService;

    /**
     * 跳转到商品详情页
     * @param id
     * @param model
     * @return
     */
    @GetMapping("{id}.html")
    public String toItemPage(@PathVariable("id")Long id, Model model) {
        // 加载所需的数据
        Map<String, Object> modelMap = this.pageService.loadModel(id);
        // 判断是否需要生成新的页面
        if(!this.fileService.exists(id)){
            this.fileService.syncCreateHtml(id);
        }
        // 放入模型
        model.addAllAttributes(modelMap);

        return "item";
    }
}
