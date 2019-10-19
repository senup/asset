package com.dbis.asset.controller;

import com.dbis.asset.mapper.AssetMapper;
import com.dbis.asset.pojo.Asset;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName AssetController
 * @Description TODO
 * @Author tom
 * @Date 2019/10/18 17:52
 * @Version 1.0
 **/
@RestController
@RequestMapping("/asset")
public class AssetController {
    @Autowired
    private AssetMapper assetMapper;



    /**
     * 功能描述: //查找所有资产，并携带类别<br>
     * 〈〉
     * @Param: [pageNum, pageSize]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: tom
     * @Date: 2019/10/19 19:11
     */
    @GetMapping
    public Map<String, Object> findAll(
            @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,
            @RequestParam(defaultValue = "5",value = "pageSize") Integer pageSize
                                           ){
        PageHelper.startPage(pageNum,pageSize);
        List<Asset> list = assetMapper.selectAllWithCategory();
        PageInfo<Asset> info = new PageInfo<>(list);
        Map<String, Object> map = new HashMap<>();
        map.put("data",info);
        map.put("status",1);
        return map;
    }



    //模糊搜索
    @GetMapping("/find")
    public Map<String,Object> findByLike(@ModelAttribute Asset asset,
                                         @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,
                                         @RequestParam(defaultValue = "5",value = "pageSize") Integer pageSize
                                         ){
        PageHelper.startPage(pageNum,pageSize);
        List<Asset> list = assetMapper.selectByLike(asset);
        PageInfo<Asset> info = new PageInfo<>(list);
        Map<String, Object> map = new HashMap<>();
        map.put("data",info);
        map.put("status",1);
        return map;
    }

    //添加资产
    @PostMapping
    public Map<String,Object> addAsset(@ModelAttribute Asset asset){
        Map<String, Object> map = new HashMap<>();
        if(assetMapper.insert(asset)>0){
            map.put("status",1);
            return map;
        }else{
            throw new RuntimeException("error");
        }
    }

    //根据id删除资产信息
    @DeleteMapping("/{id}")
    public Map<String,Object> deleteAsset(@PathVariable int id){
        Map<String, Object> map = new HashMap<>();
        if(assetMapper.deleteByPrimaryKey(id)>0){
            map.put("status" , 1);
            return map;
        }else{
            throw new RuntimeException("error");
        }
    }



    //根据Id查找资产信息
    @GetMapping("/{id}")
    public Map<String,Object> findAssetById(@PathVariable int id){
        Map<String, Object> map = new HashMap<>();
        Asset data = assetMapper.selectByPrimaryKeyWithCategory(id);
        map.put("status",1);
        map.put("data",data);
        return map;
    }

    //根据资产名称查找资产信息
    @GetMapping("/name/{name}")
    public Map<String,Object> findDeviceByName(@PathVariable String name){
        Map<String, Object> map = new HashMap<>();
        Asset data = assetMapper.selectByNameWithCategory(name);
        map.put("status",1);
        map.put("data",data);
        return map;
    }

    //更新资产信息
    @PutMapping("/")
    public Map<String,Object> updateDevice(@ModelAttribute Asset asset){
        Map<String, Object> map = new HashMap<>();
        if(assetMapper.updateByPrimaryKey(asset)>0){
            map.put("status" , 1);
            return map;
        }else{
            throw new RuntimeException("error");
        }
    }


}
