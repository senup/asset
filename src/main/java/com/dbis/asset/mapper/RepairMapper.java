package com.dbis.asset.mapper;

import com.dbis.asset.pojo.Repair;

public interface RepairMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(Repair record);

    int insertSelective(Repair record);

    Repair selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(Repair record);

    int updateByPrimaryKey(Repair record);
}