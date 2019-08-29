package com.leyou.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;


/**
 * @author wfl
 * @description
 */
@Data
@ConfigurationProperties(prefix = "ly.filter")
public class FilterProperties {
    // 并不是所有的路径都拦截，比如：不需要登录也可以浏览商品
    private List<String> allowPaths;
}
