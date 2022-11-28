package com.ql.mall.admin.controller;

import com.ql.mall.admin.service.PmsProductCategoryService;
import com.ql.mall.admin.vo.ProductionCategoryVo;
import com.ql.mall.common.api.CommonResult;
import com.ql.mall.model.PmsProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ql on 2022/11/21
 *
 * @author ql
 */
@RestController
@RequestMapping("/productCategory")
public class PmsProductCategoryController {
    @Autowired
    private PmsProductCategoryService productCategoryService;

    @GetMapping("/listAll")
    public CommonResult<List<PmsProductCategory>> listAll() {
        List<PmsProductCategory> list = productCategoryService.list();
        return CommonResult.success(list);
    }

    @PostMapping("/add")
    public CommonResult add(@RequestBody PmsProductCategory productCategory) {
        boolean save = productCategoryService.save(productCategory);
        if (save) {
            return CommonResult.success("添加成功");
        }
        return CommonResult.failed("添加失败");
    }

    /**
     * 查看下级分类
     */
    @GetMapping("/nextLevel/{parentId}")
    public CommonResult<List<PmsProductCategory>> nextLevel(@PathVariable Integer parentId) {
        List<PmsProductCategory> pmsProductCategoryList = productCategoryService.nextLevel(parentId);
        return CommonResult.success(pmsProductCategoryList);
    }

    @PostMapping("/productCategory/update/{id}")
    public CommonResult update(@PathVariable Integer id, ProductionCategoryVo categoryVo){
        productCategoryService.update(id, categoryVo);
        return CommonResult.success(null);
    }
}
