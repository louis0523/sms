package com.huawei.sms.mapper;

import com.huawei.sms.pojo.StudentInfos;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentInfosMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudentInfos record);

    int insertSelective(StudentInfos record);

    StudentInfos selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentInfos record);

    int updateByPrimaryKey(StudentInfos record);
}