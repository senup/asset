package com.dbis.asset.mapper;

import com.dbis.asset.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * TODO 查询所有用户
     */
     List<User> queryUserList();

    /**
     * TODO 条件查询指定用户
     */

    List<User> queryUserSingleCondition(User user);
    /**
     * TODO 查询用户总数
     */
    Integer getUserTotalNumber();
    /**
     * TODO 修改更新用户数据
     */
    Integer updateUserInfomation(User user);
    /**
     * TODO 添加用户信息
     */
    Integer insertUserInformation(User user);
    /**
     * TODO 删除指定条件用户
     */
    Integer deleteUserInfomation(User user);
    /**
     * TODO 批量删除指定用户
     */
    Integer deleteMoreUserById(List<Integer> ids);


}
