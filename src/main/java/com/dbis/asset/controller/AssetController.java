package com.dbis.asset.controller;

import com.dbis.asset.mapper.AssetMapper;
import com.dbis.asset.pojo.Asset;
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

    //查找所有资产，并携带类别
    @GetMapping
    public HashMap<String,Object> findAll(){
       List<Asset> asset = assetMapper.selectAllWithCategory();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("data",asset);
        hashMap.put("status",1);
        return hashMap;
    }

    //模糊搜索
    @GetMapping("/find")
    public HashMap<String,Object> findByLike(@ModelAttribute Asset asset){
        List<Asset> data = assetMapper.selectByLike(asset);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("data",data);
        hashMap.put("status",1);
        return hashMap;
    }

    //添加资产
    @PostMapping
    public HashMap<String,Object> addAsset(@ModelAttribute Asset asset){
        HashMap<String, Object> map = new HashMap<>();
        if(assetMapper.insert(asset)!=0){
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
        if(assetMapper.deleteByPrimaryKey(id)!=0){
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
        if(assetMapper.updateByPrimaryKey(asset)!=0){
            map.put("status" , 1);
            return map;
        }else{
            throw new RuntimeException("error");
        }
    }


}
