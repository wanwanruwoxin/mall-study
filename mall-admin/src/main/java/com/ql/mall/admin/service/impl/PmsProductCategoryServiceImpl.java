package com.ql.mall.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ql.mall.admin.mapper.PmsProductCategoryMapper;
import com.ql.mall.admin.service.PmsProductCategoryService;
import com.ql.mall.admin.vo.ProductionCategoryVo;
import com.ql.mall.model.PmsProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List<PmsProductCategory> nextLevel(Integer parentId) {
        LambdaUpdateWrapper<PmsProductCategory> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(PmsProductCategory::getParentId, parentId);
        return list(wrapper);
    }

    @Override
    public void update(Integer id, ProductionCategoryVo categoryVo) throws Exception {
        // 根据id查找是否有这个分类，如果有就更新，没有就抛出异常
        PmsProductCategory category = productCategoryMapper.selectById(id);
        if (Objects.isNull(category)) {
            throw new Exception("该分类不存在");
        }
        PmsProductCategory productCategory = PmsProductCategory
                .builder()
                .parentId(categoryVo.getParentId())
                .name(categoryVo.getName())
                .level(categoryVo.getParentId() == 0 ? 0 : 1)
                .build();
        // 修改查找出的Category并更新
    }
}
