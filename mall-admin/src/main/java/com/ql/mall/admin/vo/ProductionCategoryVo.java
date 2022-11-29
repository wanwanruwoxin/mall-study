package com.ql.mall.admin.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by ql on 2022/11/28
 *
 * @author ql
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductionCategoryVo {
    private String description;
    private Long id;
    private String keywords;
    private String name;
    private Integer navStatus;
    private Long parentId;
    private List<Long> productAttributeIdList;
    private Integer productCount;
    private String productUnit;
    private Integer showStatus;
    private Integer sort;
}
