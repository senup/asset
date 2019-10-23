package com.dbis.asset.controller;

import com.dbis.asset.mapper.CategoryMapper;
import com.dbis.asset.pojo.Category;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName CategoryController
 * @Description TODO
 * @Author tom
 * @Date 2019/10/19 19:07
 * @Version 1.0
 **/
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryMapper categoryMapper;


    /**
     * 功能描述://查找所有分类 <br>
     * 〈〉
     * @Param: [pageNum, pageSize]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: tom
     * @Date: 2019/10/21 17:42
     */
    @GetMapping
    public Map<String,Object> findAll(
            @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,
            @RequestParam(defaultValue = "10",value = "pageSize") Integer pageSize
    ){
        PageHelper.startPage(pageNum,pageSize);
        Map<String, Object> map = new HashMap<>();
        //List<Category> list = categoryMapper.selectAll();
        List<Category> list = categoryMapper.select();
        PageInfo<Category> info = new PageInfo<>(list);
        map.put("data",info);
        map.put("status",1);
        return map;
    }



    /**
     * 功能描述://根据Id查找单个类别 <br>
     * 〈〉
     * @Param: [id]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: tom
     * @Date: 2019/10/21 17:43
     */
    @GetMapping("/{id}")
    public Map<String,Object> findById(@PathVariable int id){
        Map<String, Object> map = new HashMap<>();
        Category category = categoryMapper.selectByPrimaryKey(id);
        map.put("data",category);
        map.put("status",1);
        return map;

    }


    /**
     * 功能描述: //根据Id 查找单个类别底下所有资产信息<br>
     * 〈〉
     * @Param: [id]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: tom
     * @Date: 2019/10/21 17:43
     */
    @GetMapping("/detail/{id}")
    public Map<String,Object> findWithAssetById(@PathVariable int id){
        Map<String, Object> map = new HashMap<>();
        List<Category> category = categoryMapper.selectWithAsset(id);
        map.put("data",category);
        map.put("status",1);
        return map;

    }


    /**
     * 功能描述: //添加类别<br>
     * 〈〉
     * @Param: [category]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: tom
     * @Date: 2019/10/21 17:43
     */
    @PostMapping
    public Map<String,Object> addCategory(@ModelAttribute Category category){
        Map<String,Object> map = new HashMap<>();
        if(categoryMapper.insert(category)>0){
            map.put("status",1);
            return map;
        }else{
            throw new RuntimeException("error");
        }
    }


    /**
     * 功能描述: //更新类别<br>
     * 〈〉
     * @Param: [category]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: tom
     * @Date: 2019/10/21 17:43
     */
    @PutMapping
    public Map<String,Object> updateCategory(@ModelAttribute Category category){
        Map<String, Object> map = new HashMap<>();
        if(categoryMapper.updateByPrimaryKey(category)>0){
            map.put("status",1);
            return map;
        }else{
            throw new RuntimeException("error");
        }

    }


    /**
     * 功能描述: //删除类别<br>
     * 〈〉
     * @Param: [id]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: tom
     * @Date: 2019/10/21 17:43
     */
    @DeleteMapping("/{id}")
    public Map<String,Object> deleteCategory(@PathVariable int id){
        Map<String, Object> map = new HashMap<>();
        if(categoryMapper.deleteByPrimaryKey(id)>0){
            map.put("status",1);
            return map;
        }else{
            throw new RuntimeException("error");
        }
    }
}
