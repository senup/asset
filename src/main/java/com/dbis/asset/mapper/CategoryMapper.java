package com.dbis.asset.mapper;

import com.dbis.asset.pojo.Asset;
import com.dbis.asset.pojo.Category;

import java.util.List;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer cid);

    List<Category> selectAll();

    //
    List<Category> select();

    //根据名字查询信息
    Category selectByName(String cateName);

    List<Category> selectWithAsset(int cid);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}