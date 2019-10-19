package com.dbis.asset.controller;

import com.dbis.asset.mapper.UserMapper;
import com.dbis.asset.pojo.User;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author dsl
 * @date 2019/10/13 15:45
 * @description
 */

/*
* HttpStatus.OK = 200;
* HttpStatus.BAD_REQUEST = 400;
* HttpStatus.FORBIDDEN = 403;
* HttpStatus.NOT_FOUND = 404;
* HttpStatus.REQUEST_TIMEOUT = 408;
* HttpStatus.SERVICE_UNAVAILABLE =500;
* 【GET】 /users # 查询用户信息列表
* 【GET】 /users/1001 # 查看某个用户信息
* 【POST】 /users # 新建用户信息
* 【PUT】 /users/1001 # 更新用户信息(全部字段)
* 【PATCH】 /users/1001 # 更新用户信息(部分字段)
* 【DELETE】 /users/1001 # 删除用户信息
*/

@RequestMapping("v1/users")
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;
    private List<User> users;
    private User user = new User();

    /*
     * @Description //TODO 查询所有用户 OK
     * @Date 2019/10/15 1:19
     * @Param
     * @return
     **/
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

    /*
     * @Description //TODO 单条件查询指定用户 OK
     * @Date 2019/10/15 2:12
     * @Param
     * @return
     **/
    @GetMapping("list/condition")
    public ResponseEntity<List<User>> queryUserSingleCondition(User conditionUser) {
        //测试开始
//        conditionUser.setId(1);
//        conditionUser.setUserName("邓22");
        //测试结束
        //“将conditionUser传来的条件注入到user中”
        user = conditionUser;
        //执行sql语句
        users = this.userMapper.queryUserSingleCondition(user);
        if (null != users) {
            //
            return new ResponseEntity<List<User>>(users, HttpStatus.OK);
        }
        //500
        return new ResponseEntity<List<User>>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /*
     * @Description //TODO 查询用户总数 OK
     * @Date 2019/10/15 2:22
     * @Param
     * @return
     **/
    @GetMapping("/total")
    public ResponseEntity<Integer> getUserTotalNumber() {

        //执行sql语句
        Integer i = this.userMapper.getUserTotalNumber();
        if (i >= 0) {
            //
            return new ResponseEntity<Integer>(i, HttpStatus.OK);
        }
        //500
        return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /*
     * @Description //TODO 更新用户数据 OK
     * @Date 2019/10/15 2:23
     * @Param
     * @return
     **/
    @PutMapping("/")
    public ResponseEntity<Integer> updateUserInfomation(User user1) {
        //测试开始
//        user1.setId(7);
//        user1.setUserPassword("123456");
//        user1.setUserNickname("qiqi");
        //测试结束
        user = user1;
        Integer i = this.userMapper.updateUserInfomation(user);
        if (i >= 0) {
            //
            return new ResponseEntity<Integer>(i, HttpStatus.OK);
        }
        //500
        return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /*
     * @Description //TODO 添加用户信息 OK
     * @Date 2019/10/15 2:30
     * @Param
     * @return
     **/
    @PostMapping("/insert")
    public ResponseEntity<Integer> insertUserInformation(User user1) {
        //测试开始
//        user1.setUserName("邓1010");
//        user1.setUserPassword("999");
        //测试结束
        user = user1;
        Integer i = this.userMapper.insertUserInformation(user);
        if (i > 0) {
            //
            return new ResponseEntity<Integer>(i, HttpStatus.CREATED);
        }
        //500
        return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /*
     * @Description //TODO 删除指定条件用户 OK
     *
     *                 ---------------DELETE又不行 报错405
     * @Date 2019/10/15 2:35
     * @Param
     * @return
     **/
    @DeleteMapping("/delete")
    public ResponseEntity<Integer> deleteUserInfomation(User user1) {
        //测试开始
//        user1.setId(10);
//        user1.setUserName("邓1010");
        //测试结束
        user = user1;
        Integer i = this.userMapper.deleteUserInfomation(user);
        if (i > 0) {
            //
            return new ResponseEntity<Integer>(i, HttpStatus.CREATED);
        }
        //500
        return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /*
     * @Description //TODO 批量删除指定ID用户
     *                 json传入List<Integer>??
     * @Date 2019/10/15 2:38
     * @Param
     * @return
     **/
    @DeleteMapping("delete/more")
    public ResponseEntity<Integer> deleteMoreUserById(List<Integer> ids) {
        //测试开始
//        ids.add(8);
//        ids.add(9);
        //测试结束
        //执行sql语句
        Integer i = this.userMapper.deleteMoreUserById(ids);
        if (i > 0) {
            //
            return new ResponseEntity<Integer>(i, HttpStatus.OK);
        }
        //500
        return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @GetMapping("list/{pageNum}")
    public ResponseEntity<List<User>> queryUserListPage(@PathVariable Integer pageNum,
                                                        @RequestParam(defaultValue = "5",value = "pageSize") Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        //执行sql语句
        users = this.userMapper.queryUserList();

        for (User user : users) {
            System.out.println(user);
        }
        if (!users.isEmpty()) {
            //
            return new ResponseEntity<List<User>>(users, HttpStatus.OK);
        }
        //500
        return new ResponseEntity<List<User>>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
