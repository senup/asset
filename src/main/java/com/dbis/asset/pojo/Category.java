package com.dbis.asset.pojo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class Category {

    private Integer cid;

    private String cateName;

    private Integer num;

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