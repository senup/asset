package com.dbis.asset.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Category {
    private Integer cid;

    private String cateName;

    private List<Asset> assets;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName == null ? null : cateName.trim();
    }
}