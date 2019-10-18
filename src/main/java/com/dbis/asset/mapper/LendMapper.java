package com.dbis.asset.mapper;

import com.dbis.asset.pojo.Lend;

public interface LendMapper {
    int deleteByPrimaryKey(Integer lid);

    int insert(Lend record);

    int insertSelective(Lend record);

    Lend selectByPrimaryKey(Integer lid);

    int updateByPrimaryKeySelective(Lend record);

    int updateByPrimaryKey(Lend record);
}