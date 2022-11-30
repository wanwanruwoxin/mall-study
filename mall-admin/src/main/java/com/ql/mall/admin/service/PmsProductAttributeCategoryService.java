package com.ql.mall.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ql.mall.admin.dto.ProductAttributeCategoryDto;
import com.ql.mall.model.PmsProductAttributeCategory;

import java.util.List;

/**
 * Created by ql on 2022/11/30
 *
 * @author ql
 */
public interface PmsProductAttributeCategoryService extends IService<PmsProductAttributeCategory> {
    List<ProductAttributeCategoryDto> getListWithAttr();
}
