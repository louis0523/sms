/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 */

package com.huawei.sms.pojo.bean;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "接口返回结果实体")
public class BaseResult implements Serializable {
    /**
     * 返回编码
     */
    private int code;
    /**
     * 返回信息
     */
    private String mag;
    /**
     * 返回数据
     */
    private Object data;

    private static final long serialVersionUID = 1L;
}
