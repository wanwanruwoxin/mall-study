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
    private Integer id;
    private String keywords;
    private String name;
    private Integer navStatus;
    private Long parentId;
    private List<Integer> productAttributeIdList;
    private Long productCount;
    private String productUnit;
    private Integer showStatus;
    private Integer sort;
}
