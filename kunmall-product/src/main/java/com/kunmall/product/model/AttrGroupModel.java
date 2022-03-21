package com.kunmall.product.model;

import com.kunmall.common.utils.QueryPageRequest;
import io.swagger.annotations.ApiModelProperty;

public class AttrGroupModel extends QueryPageRequest {
    @ApiModelProperty(notes = "关键字")
    private String key;

    @ApiModelProperty(notes = "分类ID")
    private String categoryId;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}
