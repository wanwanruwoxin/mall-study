package com.ql.mall.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ql.mall.admin.mapper.PmsProductCategoryMapper;
import com.ql.mall.admin.service.PmsProductCategoryService;
import com.ql.mall.model.PmsProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ql on 2022/11/21
 *
 * @author ql
 */
@Service
public class PmsProductCategoryServiceImpl extends ServiceImpl<PmsProductCategoryMapper, PmsProductCategory> implements PmsProductCategoryService {
    @Autowired
    private PmsProductCategoryMapper productCategoryMapper;

    @Override
    public List<PmsProductCategory> nextLevel(Integer parentId) {
        LambdaUpdateWrapper<PmsProductCategory> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(PmsProductCategory::getParentId, parentId);
        return list(wrapper);
    }
}
