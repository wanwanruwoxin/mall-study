package com.ql.mall.admin.dto;

import com.ql.mall.model.PmsProductAttribute;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by ql on 2022/11/30
 *
 * @author ql
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductAttributeCategoryDto {
    private Long id;
    private String name;
    private Integer attributeCount;
    private Integer paramCount;
    private List<PmsProductAttribute> productAttributeList;
}
