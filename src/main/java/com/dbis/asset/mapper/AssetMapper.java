package com.dbis.asset.mapper;

import com.dbis.asset.pojo.Asset;

import java.util.List;

public interface AssetMapper {
    int deleteByPrimaryKey(Integer aid);

    int insert(Asset record);

    int insertSelective(Asset record);

    Asset selectByPrimaryKey(Integer aid);

    //
    Asset selectByNameWithCategory(String name);

    //
    List<Asset> selectAllWithCategory();

    //
    List<Asset> selectByLike(Asset asset);

    //
    Asset selectByPrimaryKeyWithCategory(Integer aid);

    int updateByPrimaryKeySelective(Asset record);

    int updateByPrimaryKey(Asset record);
}