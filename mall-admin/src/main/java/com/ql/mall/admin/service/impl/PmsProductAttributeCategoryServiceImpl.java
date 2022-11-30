package com.ql.mall.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ql.mall.admin.dto.ProductAttributeCategoryDto;
import com.ql.mall.admin.mapper.PmsProductAttributeCategoryMapper;
import com.ql.mall.admin.mapper.PmsProductAttributeMapper;
import com.ql.mall.admin.service.PmsProductAttributeCategoryService;
import com.ql.mall.model.PmsProductAttribute;
import com.ql.mall.model.PmsProductAttributeCategory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ql on 2022/11/30
 *
 * @author ql
 */
@Service
public class PmsProductAttributeCategoryServiceImpl extends ServiceImpl<PmsProductAttributeCategoryMapper, PmsProductAttributeCategory> implements PmsProductAttributeCategoryService {
    @Autowired
    private PmsProductAttributeCategoryMapper productAttributeCategoryMapper;
    @Autowired
    private PmsProductAttributeMapper productAttributeMapper;

    @Override
    public List<ProductAttributeCategoryDto> getListWithAttr() {
        List<ProductAttributeCategoryDto> list = new ArrayList<>();
        // 查询PmsProductAttributeCategory中的所有数据
        List<PmsProductAttributeCategory> productAttributeCategoryList = productAttributeCategoryMapper.selectList(null);
        // 根据每个PmsProductAttributeCategory查找对应的PmsProductAttribute
        productAttributeCategoryList.forEach(item -> {
            List<PmsProductAttribute> productAttributeList = productAttributeMapper.selectList(new LambdaQueryWrapper<PmsProductAttribute>()
                    .eq(PmsProductAttribute::getProductAttributeCategoryId, item.getId())
                    .eq(PmsProductAttribute::getType, 1));
            // 将PmsProductAttributeCategory和对应的PmsProductAttribute封装到ProductAttributeCategoryDto里面
            ProductAttributeCategoryDto productAttributeCategoryDto = new ProductAttributeCategoryDto();
            BeanUtils.copyProperties(item, productAttributeCategoryDto);
            productAttributeCategoryDto.setProductAttributeList(productAttributeList);
            list.add(productAttributeCategoryDto);
        });
        return list;
    }
}
