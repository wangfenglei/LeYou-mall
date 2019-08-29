package com.leyou.pojo;

import java.util.Map;

/**
 * @author wfl
 * @description
 */
public class SearchRequest {

    private static final Integer DEFAULT_SIZE = 20;// 每页大小，不从页面接收，而是固定大小
    private static final Integer DEFAULT_PAGE = 1;// 默认页


    private String key;// 搜索条件

    private Integer page;// 当前页

    private String sortBy;

    private Boolean descending;

    private Map<String, String> filter;




    public String getSortBy() {
        return sortBy;
    }

    public void setSprtBy(String sprtBy) {
        this.sortBy = sprtBy;
    }

    public Boolean getDescending() {
        return descending;
    }

    public void setDescending(Boolean descending) {
        this.descending = descending;
    }

    public void setFilter(Map<String, String> filter) {
        this.filter = filter;
    }


    public Map<String, String> getFilter() {
        return filter;
    }
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getPage() {
        if(page == null){
            return DEFAULT_PAGE;
        }
        // 获取页码时做一些校验，不能小于1
        return Math.max(DEFAULT_PAGE, page);
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return DEFAULT_SIZE;
    }
}
