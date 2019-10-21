package com.dbis.asset.controller;

import com.dbis.asset.mapper.UserMapper;
import com.dbis.asset.pojo.User;
import com.dbis.asset.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dsl
 * @date 2019/10/13 15:45
 * @description
 */
@RequestMapping("users")
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    Map<String, Object> map = new HashMap<>();
    private List<User> users;
    private User user = new User();



    /*
     * @Description //TODO 查询所有用户(分页)
     * @Date 2019/10/20 13:48
     * @Param
     * @return
     **/
    @GetMapping
    public Map<String, Object> queryUserListPage(
            @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,
            @RequestParam(defaultValue = "5",value = "pageSize") Integer pageSize) {
        //分页
        PageHelper.startPage(pageNum, pageSize);
        //执行sql语句
        users = this.userService.queryUserList();
        //
        PageInfo<User> info = new PageInfo<>(users);

        map.put("data", info);
        map.put("status", 1);

        for (User user : users) {
            System.out.println(user);
        }
        return map;
    }



    /*
     * @Description //TODO 单条件查询指定用户 OK
     * @Date 2019/10/15 2:12
     * @Param
     * @return
     **/
    @GetMapping("/condition")
    public Map<String, Object> queryUserSingleCondition(User conditionUser,
                                                        @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,
                                                        @RequestParam(defaultValue = "5",value = "pageSize") Integer pageSize) {
        user = conditionUser;
        PageHelper.startPage(pageNum, pageSize);
        //执行sql语句
        users = this.userService.queryUserSingleCondition(user);
        PageInfo<User> info = new PageInfo<>(users);
        if (users.isEmpty()) {
            map.put("status", 0);
        } else {
            map.put("date", info);
            map.put("status", 1);
        }
        return map;
    }

    /*
     * @Description //TODO 查询用户总数 OK
     * @Date 2019/10/15 2:22
     * @Param
     * @return
     **/
    @GetMapping("/total")
    public Map<String, Object> getUserTotalNumber() {

        //执行sql语句
        Integer i = this.userService.getUserTotalNumber();
        if (i >= 0) {
            map.put("date", i);
            map.put("status", 1);
        } else {
            map.put("status", 0);
        }
        return map;
    }

    /*
     * @Description //TODO 更新用户数据 OK
     * @Date 2019/10/15 2:23
     * @Param
     * @return
     **/
    @PutMapping
    public Map<String, Object> updateUserInfomation(User user1) {
        user = user1;
        Integer i = this.userService.updateUserInfomation(user);
        if (i > 0) {
            map.put("date", i);
            map.put("status", 1);
        } else {
            map.put("date", "UpdateError");
            map.put("status", 0);
        }
        return map;
    }

    /*
     * @Description //TODO 添加用户信息 OK
     * @Date 2019/10/15 2:30
     * @Param
     * @return
     **/
    @PostMapping
    public Map<String, Object> insertUserInformation(User user1) {
        user = user1;
        System.out.println(user.getUserName()+","+user.getUserPassword());
        if (user.getUserName() != null && user.getUserName() != ""
                && user.getUserPassword() !=null && user.getUserPassword() !=""){

            Integer i = this.userService.insertUserInformation(user);
            if (i > 0) {
                map.put("date", i);
                map.put("status", 1);
            }
        }else {
            map.put("status", 0);
        }

        return map;
    }

    /*
     * @Description //TODO 删除指定条件用户 OK
     *
     *                 ---------------DELETE又不行 报错405
     * @Date 2019/10/15 2:35
     * @Param
     * @return
     **/
    @DeleteMapping
    public Map<String, Object> deleteUserInfomation(User user1) {
        user = user1;
        Integer i = this.userService.deleteUserInfomation(user);
        if (i > 0) {
            map.put("date", i);
            map.put("status", 1);
        } else {
            map.put("status", 0);
        }
        return map;
    }


/*
    /*
     * @Description //TODO 批量删除指定ID用户
     * @Date 2019/10/15 2:38
     * @Param
     * @return
     **//*
    @DeleteMapping("/more")
    public Map<String, Object> deleteMoreUserById(List<Integer> ids) {
        //测试开始
//        ids.add(8);
//        ids.add(9);
        //测试结束
        //执行sql语句
        Integer i = this.userMapper.deleteMoreUserById(ids);
        if (i > 0) {
            map.put("date", i);
            map.put("status", 1);
        } else {
            map.put("status", 0);
        }
        return map;
    }
*/


/*
    /*
     * @Description //TODO 查询所有用户 OK
     * @Date 2019/10/15 1:19
     * @Param
     * @return
     **//*
    @GetMapping("/list")
    public ResponseEntity<List<User>> queryUserList() {
//        PageHelper.startPage(1,5);
        //执行sql语句
        users = this.userMapper.queryUserList();
        if (null != users) {
            //响应数据
            return new ResponseEntity<List<User>>(users, HttpStatus.OK);
        }
        //500
        return new ResponseEntity<List<User>>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
*/
}