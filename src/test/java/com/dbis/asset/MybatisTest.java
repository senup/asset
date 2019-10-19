//package com.dbis.asset;
//
//
//import com.dbis.asset.mapper.UserMapper;
//import com.dbis.asset.pojo.User;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author dsl
// * @date 2019/10/13 16:02
// * @description
// */
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = SpringbootMybatisApplication.class)
//public class MybatisTest {
//
//    @Autowired
//    private UserMapper userMapper;
//    private User user = new User();
//
//    /*
//     * TODO 测试查询全部
//     */
//    @Test
//    public void testqueryUserList(){
//
//        List<User> users = userMapper.queryUserList();
//        for(User u : users){
//            System.out.println(u);
//        }
//    }
//
//    /*
//     * TODO 测试单条件查询
//     */
//    @Test
//    public void testqueryUserSingleCondition(){
////        user.setId(1);
////        user.setUserName("邓");
////        user.setUserNickname("一");
////        user.setUserPhoneNo("15959734278");
////        user.setUserGender("男");
//        user.setUserMail("123");
//        List<User> users = userMapper.queryUserSingleCondition(user);
//        for(User u : users){
//            System.out.println(u);
//        }
//    }
//
//    /*
//     * TODO 测试查询用户总数
//     */
//    @Test
//    public void testGetUseTotalNumber() {
//
////        Integer useTotalNumber = userMapper.getUseTotalNumber();
////        System.out.println(useTotalNumber);
//    }
//
//    /*
//     * TODO 测试修改用户信息
//     */
//    @Test
//    public void testUpdateUserInfomation() {
//        user.setId(2);
//        user.setUserPassword("456");
//        user.setUserName("邓11");
//        user.setUserNickname("一一一");
//        user.setUserPhoneNo("15994969293");
//        user.setUserGender("女");
//        user.setUserMail("956923045@qq.com");
//        user.setUserBirthday("1997-12-30");
//        user.setUserState(1);//1-127
//        user.setUserIsAdministrator(0);
//        user.setUserSort("未分类");
//        user.setUserDepartment("暂无部门");
//        user.setUserPrivilege("暂无权限限制");
//        user.setUserMotto("这是我的个性签名");
//        user.setUserHobby("这是我的爱好描述");
//        user.setUserNewpassword("123");//无法设置为NUll、""\\\
//        Integer i = userMapper.updateUserInfomation(user);
//        System.out.println(i);
//    }
//
//    /*
//     * TODO 测试添加用户信息
//     */
//    @Test
//    public void testInsertUserInformation() {
//        user.setUserName("邓66");
//        user.setUserPassword("456");
//        user.setUserNickname("一一一");
//        user.setUserPhoneNo("15994969293");
//        user.setUserGender("女");
//        user.setUserMail("956923045@qq.com");
//        user.setUserBirthday("1997-12-30");
//        user.setUserState(1);//1-127
//        user.setUserIsAdministrator(0);
//        user.setUserSort("未分类");
//        user.setUserDepartment("暂无部门");
//        user.setUserPrivilege("暂无权限限制");
//        user.setUserMotto("这是我的个性签名");
//        user.setUserHobby("这是我的爱好描述");
//        user.setUserNewpassword("123");//无法设置为NUll、""\\\
//        Integer i = userMapper.insertUserInformation(user);
//        System.out.println(i);
//    }
//
//    /*
//     * TODO 测试删除指定用户
//     */
//    @Test
//    public void testDeleteUserInfomation() {
//        user.setId(7);
//        user.setUserName("邓77");
///*        user.setUserPassword("456");
//        user.setUserNickname("一一一");
//        user.setUserPhoneNo("15994969293");
//        user.setUserGender("女");
//        user.setUserMail("956923045@qq.com");
//        user.setUserBirthday("1997-12-30");
//        user.setUserState(1);//1-127
//        user.setUserIsAdministrator(0);
//        user.setUserSort("未分类");
//        user.setUserDepartment("暂无部门");
//        user.setUserPrivilege("暂无权限限制");
//        user.setUserMotto("这是我的个性签名");
//        user.setUserHobby("这是我的爱好描述");
//        user.setUserNewpassword("123");//无法设置为NUll、""\\\*/
//        Integer i = userMapper.deleteUserInfomation(user);
//        System.out.println(i);
//    }
//
//    /*
//     * TODO 测试批量删除指定用户
//     */
//    @Test
//    public void testDeleteMoreUserById() {
//        ArrayList<Integer> ids = new ArrayList<>();
//        ids.add(8);
//        ids.add(9);
//        Integer i = userMapper.deleteMoreUserById(ids);
//        System.out.println(i);
//    }
//
//    @Test
//    public void testQueryUserListPage() {
//        PageHelper.startPage(2,5);
//        //执行sql语句
//        List<User> users = this.userMapper.queryUserList();
////        PageInfo<User> userPageInfo = new PageInfo<User>(users);
////        model.addAttribute("pageInfo",userPageInfo);
//
//        for (User user : users) {
//            System.out.println(user);
//        }
//    }
//}
