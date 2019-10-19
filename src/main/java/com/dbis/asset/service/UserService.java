package com.dbis.asset.service;

import com.dbis.asset.mapper.UserMapper;
import com.dbis.asset.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * TODO 查询所有用户
     */
    public List<User> queryUserList(){

        return userMapper.queryUserList();
    }

    /**
     * TODO 条件查询指定用户
     */

    public List<User> queryUserSingleCondition(User user){

        return userMapper.queryUserSingleCondition(user);
    }
    /**
     * TODO 查询用户总数
     */
    public Integer getUserTotalNumber(){

        return userMapper.getUserTotalNumber();
    }
    /**
     * TODO 修改更新用户数据
     */
    public Integer updateUserInfomation(User user){

        return userMapper.updateUserInfomation(user);
    }
    /**
     * TODO 添加用户信息
     */
    public Integer insertUserInformation(User user){

        return userMapper.insertUserInformation(user);
    }
    /**
     * TODO 删除指定条件用户
     */
    public Integer deleteUserInfomation(User user){

        return userMapper.deleteUserInfomation(user);
    }
    /**
     * TODO 批量删除指定用户
     */
    public Integer deleteMoreUserById(List<Integer> ids){

        return userMapper.deleteMoreUserById(ids);
    }


}
