package com.huawei.sms.mapper;

import com.huawei.sms.pojo.SecretInfos;

public interface SecretInfosMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SecretInfos record);

    int insertSelective(SecretInfos record);

    SecretInfos selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SecretInfos record);

    int updateByPrimaryKey(SecretInfos record);
}