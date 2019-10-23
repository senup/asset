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

    //--------------------------未测试------------------------------------
    /*
     * @Description //TODO 注册
     *                  注册失败
     *                      空或存在 返回-1
     *                      密码为空 返回-2
     *                      邮箱为空 返回-3
     *                      数据库插入异常 返回0
     *                  注册成功 返回1
     * @Date 2019/10/23 0:57
     * @Param [user]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @GetMapping("/register")
    public Map<String, Object> register(User user){
        Map<String, Object> map = new HashMap<>();
        Integer i = userService.register(user);
        if (i == 1){
            List<User> users = userService.queryUserSingleCondition(user);
            if (users.size() == 1){
                User user1 = users.get(0);
//                System.out.println(user1);
                map.put("status", 1);
                map.put("message",user.getUserName() + "注册成功！");
                map.put("data",user1);
            }else {
                map.put("status", 0);
                map.put("message","数据重复异常！");
            }
        } else if (i == -1){
            map.put("status", 0);
            map.put("message","用户名为空或已存在！");
        } else if (i == -3) {
            map.put("status", 0);
            map.put("message","邮箱为空/不存在！");
        } else {
            map.put("status", 0);
            map.put("message","数据库异常！");
        }
        return map;
    }

    /*
     * @Description  TODO 登录校验
     *                   失败
     *                      用户名不存在返回0
     *                      空返回-1
     *                      密码错误返回-2
     *                      登录成功返回1，
     * @Date 2019/10/23 0:58
     * @Param [user]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @GetMapping("/login")
    public Map<String, Object> login(User user){
        Map<String, Object> map = new HashMap<>();
        Integer i = userService.login(user);
        System.out.println(i);
        if (i == 1){
            List<User> users = userService.queryUserSingleCondition(user);
            User user1 = users.get(0);
            map.put("status", 1);
            map.put("message",user.getUserName() + "登录成功！");
            map.put("data",user1);
        } else if (i == -2) {
            map.put("status", 0);
            map.put("message","密码错误！");
        } else {
            map.put("status", 0);
            map.put("message","用户名为空或不存在！");
        }
        return map;
    }

    //-------------------------------------------------
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