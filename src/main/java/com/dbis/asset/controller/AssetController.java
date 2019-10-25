package com.dbis.asset.controller;

import com.dbis.asset.enums.CommonEnum;
import com.dbis.asset.exception.BizException;
import com.dbis.asset.mapper.AssetMapper;
import com.dbis.asset.pojo.Asset;
import com.dbis.asset.result.ResultBody;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResultBody findAll(
            @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,
            @RequestParam(defaultValue = "10",value = "pageSize") Integer pageSize
                                           ){
        PageHelper.startPage(pageNum,pageSize);
        List<Asset> list = assetMapper.selectAllWithCategory();
        if(list.isEmpty()){
            throw  new BizException(CommonEnum.NOT_FOUND);
        }
        PageInfo<Asset> info = new PageInfo<>(list);
        return ResultBody.success(info);
    }




    /**
     * 功能描述: //模糊搜索<br>
     * 〈〉
     * @Param: [asset, pageNum, pageSize]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: tom
     * @Date: 2019/10/21 17:42
     */
    @GetMapping("/find")
    public ResultBody findByLike(@ModelAttribute Asset asset,
                                         @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,
                                         @RequestParam(defaultValue = "10",value = "pageSize") Integer pageSize
                                         ){
        PageHelper.startPage(pageNum,pageSize);
        List<Asset> list = assetMapper.selectByLike(asset);
        if(list.isEmpty()){
            throw  new BizException(CommonEnum.NOT_FOUND);
        }
        PageInfo<Asset> info = new PageInfo<>(list);
        return ResultBody.success(info);
    }


    /**
     * 功能描述: //添加资产<br>
     * 〈〉
     * @Param: [asset]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: tom
     * @Date: 2019/10/21 17:42
     */
    @PostMapping
    public ResultBody addAsset(Asset asset){
        if(asset.getAssetName().isEmpty()){
            throw  new BizException(CommonEnum.BODY_NOT_MATCH.getResultCode(),"资产名不能为空！");
        }
        if(asset.getUserId()==null){
            throw  new BizException(CommonEnum.BODY_NOT_MATCH.getResultCode(),"用户userId不能为空！");
        }
        if(asset.getCateId()==null){
            throw  new BizException(CommonEnum.BODY_NOT_MATCH.getResultCode(),"类别cateId不能为空！");
        }
        if(assetMapper.insert(asset)!=1){
            throw  new BizException("-1","插入操作失败！");
        }else{
            return ResultBody.success();
        }
    }


    /**
     * 功能描述: //根据id删除资产信息<br>
     * 〈〉
     * @Param: [id]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: tom
     * @Date: 2019/10/21 17:42
     */
    @DeleteMapping("/{aid}")
    public ResultBody deleteAsset(@PathVariable int aid){
        int i = assetMapper.deleteByPrimaryKey(aid);
        if(i != 1){
            throw  new BizException("-1","删除操作失败！");
        }
        return ResultBody.success();
    }




    /**
     * 功能描述: //根据Id查找资产信息<br>
     * 〈〉
     * @Param: [id]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: tom
     * @Date: 2019/10/21 17:42
     */
    @GetMapping("/detail/{aid}")
    public ResultBody findAssetById(@PathVariable int aid){
        Asset data = assetMapper.selectByPrimaryKeyWithCategory(aid);
        if(data==null){
            throw new BizException(CommonEnum.NOT_FOUND);
        }
        return ResultBody.success(data);
    }



    /**
     * 功能描述: //更新资产信息<br>
     * 〈〉
     * @Param: [asset]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: tom
     * @Date: 2019/10/21 17:42
     */
    @PutMapping
    public ResultBody updateAsset(Asset asset){
        if(asset.getAid()==null){
            throw  new BizException(CommonEnum.BODY_NOT_MATCH.getResultCode(),"资产aid不能为空！");
        }
        int i = assetMapper.updateByPrimaryKey(asset);
        if( i !=1){
            throw  new BizException("-1","更新操作失败！");
        }
        return ResultBody.success();
    }


}
