package com.ql.mall.admin.controller;

import com.ql.mall.admin.dto.ProductAttributeCategoryDto;
import com.ql.mall.admin.service.PmsProductAttributeCategoryService;
import com.ql.mall.common.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ql on 2022/11/30
 *
 * @author ql
 */
@RestController
@RequestMapping("/productAttribute/category")
public class PmsProductAttributeCategoryController {
    @Autowired
    private PmsProductAttributeCategoryService productAttributeCategoryService;

    @GetMapping("/list/withAttr")
    public CommonResult<List<ProductAttributeCategoryDto>> getListWithAttr(){
        List<ProductAttributeCategoryDto> list = productAttributeCategoryService.getListWithAttr();
        return CommonResult.success(list);
    }

}
