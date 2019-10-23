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

    //------------------------------------------
    /*
     * TODO 用户名存在？
     *  为空返回-1
     *  存在返回1
     *  不存在返回0
     */
    public Integer userNameExist(User user){
        if (user.getUserName() == null || "".equals(user.getUserName())) {
//            System.out.println(user.getUserName());
//            System.out.println(user.getUserName());
            return -1;
        }
//        User u = new User();
        for (User userlist : userMapper.queryUserSingleCondition(user)) {
            if (userlist.getUserName().equals(user.getUserName())){
                return 1;
            }
        }
        return 0;
    }

    /*
     * TODO 注册
     *  注册失败
     *      空或存在 返回-1
     *      插入异常 返回0
     *      密码为空 返回-2
     *      邮箱为空 返回-3
     *  注册成功 返回1
     */
    public Integer register(User user){
        //用户名存在或空
        Integer i = userNameExist(user);
        if (i != 0) {
            return -1;
        }
        if (user.getUserIsAdministrator() == null){
            user.setUserIsAdministrator(0);
        }
        if (user.getUserPassword() == null || "".equals(user.getUserPassword())) {
            return -2;
        }
        if (user.getUserMail() == null || "".equals(user.getUserMail())) {
            return -3;
        }
//        插入成功返回1
//            失败返回0
        return userMapper.insertUserInformation(user);
    }


    /*
     * TODO 登录校验
     *  失败
     *       用户名不存在返回0
     *       空返回-1
     *       密码错误返回-2
     *  登录成功返回1，
     */
    public Integer login(User user){
        Integer i = userNameExist(user);
        //用户名不存在或空
        if (i == 0 || i == -1) {
            return i;
        }
        for (User userlist : userMapper.queryUserSingleCondition(user)) {
            if (userlist.getUserName().equals(user.getUserName())){
                return 1;
            }
        }
        return -2;
    }
    //-------------------------------------

}
