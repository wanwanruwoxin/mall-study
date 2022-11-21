package com.ql.mall.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ql.mall.model.PmsProductCategory;

import java.util.List;

/**
 * Created by ql on 2022/11/21
 *
 * @author ql
 */
public interface PmsProductCategoryService extends IService<PmsProductCategory> {

    List<PmsProductCategory> nextLevel(Integer parentId);
}
