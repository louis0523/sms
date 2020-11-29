/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 */

package com.huawei.sms.mapper;

import com.huawei.sms.pojo.SecretInfos;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SecretInfosMapper {
    int deleteByPrimaryKey(String stuNo);

    int insert(SecretInfos record);

    int insertSelective(SecretInfos record);

    SecretInfos selectByPrimaryKey(String stuNo);

    int updateByPrimaryKeySelective(SecretInfos record);

    int updateByPrimaryKey(SecretInfos record);
}