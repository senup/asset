package com.dbis.asset.controller;

import com.dbis.asset.enums.CommonEnum;
import com.dbis.asset.exception.BizException;
import com.dbis.asset.mapper.CategoryMapper;
import com.dbis.asset.pojo.Category;
import com.dbis.asset.result.ResultBody;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryMapper categoryMapper;


    /**
     * 功能描述:查询所有类别 <br>
     * 〈〉
     * @Param: [pageNum, pageSize]
     * @Return: com.dbis.asset.result.ResultBody
     * @Author: tom
     * @Date: 2019/10/24 22:24
     */
    @GetMapping
    public ResultBody findAll(
            @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,
            @RequestParam(defaultValue = "10",value = "pageSize") Integer pageSize
    ){
        //设置页数页码
        PageHelper.startPage(pageNum,pageSize);
        //查询的数据集
        List<Category> list = categoryMapper.select();
        //判断是否为空
        if(list.isEmpty()){
            throw  new BizException(CommonEnum.NOT_FOUND);
        }
        //进行分页
        PageInfo<Category> info = new PageInfo<>(list);
        //返回数据
        return ResultBody.success(info);
    }



    /**
     * 功能描述: 根据id查询，返回单条数据<br>
     * 〈〉
     * @Param: [cid]
     * @Return: com.dbis.asset.result.ResultBody
     * @Author: tom
     * @Date: 2019/10/24 22:25
     */
    @GetMapping("/{cid}")
    public ResultBody findById(@PathVariable int cid){
        Category category = categoryMapper.selectByPrimaryKey(cid);
        //如果找不到该资产
        if(category==null){
            throw new BizException(CommonEnum.NOT_FOUND);
        }
        return ResultBody.success(category);
    }



    /**
     * 功能描述: 根据id查询某个类别下的资产<br>
     * 〈〉
     * @Param: [cid]
     * @Return: com.dbis.asset.result.ResultBody
     * @Author: tom
     * @Date: 2019/10/24 22:25
     */
    @GetMapping("/detail/{cid}")
    public ResultBody findWithAssetById(@PathVariable int cid,
                                        @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,
                                        @RequestParam(defaultValue = "10",value = "pageSize") Integer pageSize
    ){
        PageHelper.startPage(pageNum,pageSize);
        List<Category> category = categoryMapper.selectWithAsset(cid);
        //如果找不到
        if(category.isEmpty()){
            throw new BizException(CommonEnum.NOT_FOUND);
        }
        //进行分页
        PageInfo<Category> info = new PageInfo<>(category);
        return ResultBody.success(info);
    }


    /**
     * 功能描述: 添加类别<br>
     * 〈〉
     * @Param: [category]
     * @Return: com.dbis.asset.result.ResultBody
     * @Author: tom
     * @Date: 2019/10/24 22:25
     */
    @PostMapping
    public ResultBody addCategory(Category category){
        if(category.getCateName()==null || category.getCateName().isEmpty()){
            throw  new BizException(CommonEnum.BODY_NOT_MATCH.getResultCode(),"分类名不能为空！");
        }if(categoryMapper.selectByName(category.getCateName())!=null){
            throw  new BizException(CommonEnum.BODY_NOT_MATCH.getResultCode(),"插入数据重复，请换一个类别名！");
        } if(categoryMapper.insert(category)!=1){
            throw  new BizException("-1","插入操作失败！");
        }
        else{
            return ResultBody.success();
        }

    }


    /**
     * 功能描述: 更新类别<br>
     * 〈〉
     * @Param: [category]
     * @Return: com.dbis.asset.result.ResultBody
     * @Author: tom
     * @Date: 2019/10/24 22:25
     */
    @PutMapping
    public ResultBody updateCategory(Category category){
        if(category.getCid()==null){
            throw  new BizException(CommonEnum.BODY_NOT_MATCH.getResultCode(),"分类cid不能为空！");
        }
        int i = categoryMapper.updateByPrimaryKey(category);
        if( i !=1){
            throw  new BizException("-1","更新操作失败！");
        }
        return ResultBody.success();

    }


    /**
     * 功能描述: 删除类别<br>
     * 〈〉
     * @Param: [cid]
     * @Return: com.dbis.asset.result.ResultBody
     * @Author: tom
     * @Date: 2019/10/24 22:25
     */
    @DeleteMapping("/{cid}")
    public ResultBody deleteCategory(@PathVariable int cid){
        int i = categoryMapper.deleteByPrimaryKey(cid);
        if(i != 1){
            throw  new BizException("-1","删除操作失败！");
        }else{
            return ResultBody.success();
        }
    }
}
