package com.ql.mall.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ql.mall.admin.mapper.PmsProductCategoryAttributeRelationMapper;
import com.ql.mall.admin.mapper.PmsProductCategoryMapper;
import com.ql.mall.admin.service.PmsProductCategoryService;
import com.ql.mall.admin.vo.ProductionCategoryVo;
import com.ql.mall.model.PmsProductCategory;
import com.ql.mall.model.PmsProductCategoryAttributeRelation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by ql on 2022/11/21
 *
 * @author ql
 */
@Service
public class PmsProductCategoryServiceImpl extends ServiceImpl<PmsProductCategoryMapper, PmsProductCategory> implements PmsProductCategoryService {
    @Autowired
    private PmsProductCategoryMapper productCategoryMapper;
    @Autowired
    private PmsProductCategoryAttributeRelationMapper productCategoryAttributeRelationMapper;

    @Override
    public List<PmsProductCategory> nextLevel(Integer parentId) {
        LambdaUpdateWrapper<PmsProductCategory> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(PmsProductCategory::getParentId, parentId);
        return list(wrapper);
    }

    @Override
    public void update(Long id, ProductionCategoryVo categoryVo) throws Exception {
        PmsProductCategory productCategory = new PmsProductCategory();
        productCategory.setId(id);
        BeanUtils.copyProperties(categoryVo, productCategory);

        setCategoryLevel(productCategory);

        List<Long> productAttributeIdList = categoryVo.getProductAttributeIdList();

        // 删除并新增分类与产品属性的关联
        productCategoryAttributeRelationMapper.delete(new LambdaQueryWrapper<PmsProductCategoryAttributeRelation>()
                .eq(PmsProductCategoryAttributeRelation::getProductCategoryId, productCategory.getId()));
        if(!CollectionUtils.isEmpty(productAttributeIdList)) {
            productAttributeIdList.forEach(item -> {
                PmsProductCategoryAttributeRelation pmsProductCategoryAttributeRelation = new PmsProductCategoryAttributeRelation();
                pmsProductCategoryAttributeRelation.setProductCategoryId(productCategory.getId());
                pmsProductCategoryAttributeRelation.setProductAttributeId(item);
                productCategoryAttributeRelationMapper.insert(pmsProductCategoryAttributeRelation);
            });
        }

        // 修改查找出的Category并更新
        productCategoryMapper.updateById(productCategory);
    }

    private void setCategoryLevel(PmsProductCategory productCategory) {
        // 设置productCategory的level
        PmsProductCategory parentCategory = productCategoryMapper.selectOne(new LambdaQueryWrapper<PmsProductCategory>()
                .eq(PmsProductCategory::getId, productCategory.getParentId()));
        if (productCategory.getParentId() == 0) {
            productCategory.setLevel(0);
        }else {
            if (parentCategory == null) {
                productCategory.setLevel(0);
            }else {
                productCategory.setLevel(1);
            }
        }
    }
}
