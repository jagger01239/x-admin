package com.xadmin.sys.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author cdf
 * @since 2023-06-23
 */
@TableName("x_role")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Role对象", description = "")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "role_id", type = IdType.AUTO)
    private Integer roleId;

    private String roleName;

    private String roleDesc;

    @TableLogic
    private Boolean isDelete;

    @TableField(exist = false)
    private List<Integer> menuIdList;


}
