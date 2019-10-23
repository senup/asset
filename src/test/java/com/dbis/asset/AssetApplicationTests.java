package com.dbis.asset;

import com.dbis.asset.pojo.User;
import com.dbis.asset.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class AssetApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void userNameExist() {
        User user = new User();
        /*
         * TODO 用户名存在？
         *  为空返回-1
         *  存在返回1
         *  不存在返回0
         */
//        //存在 1
//        user.setUserName("邓11");
//        Integer integer = userService.userNameExist(user);
//        System.out.println(integer);
//        //为空 -1
//        user.setUserName("");
//        Integer integer = userService.userNameExist(user);
//        System.out.println(integer);
        //不存在 0
        user.setUserName("邓");
        Integer integer = userService.userNameExist(user);
        System.out.println(integer);

    }

    @Test
    void register(){
        /*
         * TODO 注册
         *  注册失败
         *      空或存在 返回-1
         *      插入异常 返回0
         *      密码为空 返回-2
         *      邮箱为空 返回-3
         *  注册成功 返回1
         */
        //存在或为空 -1
//        user.setUserName("邓11");
//        user.setUserName("");
//        Integer register = userService.register(user);
//        System.out.println(register);
        //注册成功 1
        User user = new User();
        user.setUserName("deng11");
        user.setUserPassword("123123");
        user.setUserMail("213@qq.com");
        Integer register1 = userService.register(user);
        System.out.println(register1);

    }

    @Test
    void login(){
        User user = new User();
        /*
         * TODO 登录校验
         *  失败
         *       用户名不存在返回0
         *       空返回-1
         *       密码错误返回-2
         *  登录成功返回1，
         */
        //不存在 0
//        user.setUserName("dengg");
//        user.setUserPassword("123");
//        Integer login = userService.login(user);
//        System.out.println(login);
//        //用户名为空 -1
//        user.setUserName("");
//        user.setUserPassword("123456");
//        System.out.println(userService.login(user));
//        //密码错误 -2
//        user.setUserName("邓33");
//        user.setUserPassword("999");
//        System.out.println(userService.login(user));
        //登录成功 1
        user.setUserName("邓55");
        user.setUserPassword("456");
        System.out.println(userService.login(user));
    }

    @Test
    void select(){
        User user = new User();
        user.setUserName("deng");
        List<User> users = userService.queryUserSingleCondition(user);
        User user1 = users.get(1);
        System.out.println(user1);


    }
}
