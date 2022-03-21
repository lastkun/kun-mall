package com.kunmall.common.utils;

import io.swagger.annotations.ApiModelProperty;

public class QueryPageRequest {
    //页码
    @ApiModelProperty(value = "1", notes = "页码")
    private Integer pageNum;

    @ApiModelProperty(notes = "页长")
    private Integer pageSize;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }


}
