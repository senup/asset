package com.dbis.asset.mapper;

import com.dbis.asset.pojo.Category;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer cid);



    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}