/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 */

package com.huawei.sms.pojo.bean;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
@ApiModel(description = "接口实体")
public class QueryReStuInfos {
    List<BaseReStuInfos> baseReStuInfosList;

    public QueryReStuInfos(BaseReStuInfos baseReStuInfos) {
        List<BaseReStuInfos> baseReStuInfosList =  new ArrayList<>();
        baseReStuInfosList.add(baseReStuInfos);
        this.baseReStuInfosList = baseReStuInfosList;
    }
}
