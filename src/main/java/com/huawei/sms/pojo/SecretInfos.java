package com.huawei.sms.pojo;

import java.io.Serializable;

import com.huawei.sms.pojo.bean.AddStuInfos;
import lombok.Data;

/**
 * secretinfos
 * @author 
 */
@Data
public class SecretInfos implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 父名
     */
    private String faName;

    /**
     * 父号码
     */
    private String faPhone;

    /**
     * 母名
     */
    private String moName;

    /**
     * 母号码
     */
    private String moPhone;

    /**
     * 家庭住址
     */
    private String address;

    /**
     * 学生id
     */
    private String stuNo;

    private static final long serialVersionUID = 1L;

    public SecretInfos(Integer id, String faName, String faPhone, String moName, String moPhone, String address, String stuNo) {
        this.id = id;
        this.faName = faName;
        this.faPhone = faPhone;
        this.moName = moName;
        this.moPhone = moPhone;
        this.address = address;
        this.stuNo = stuNo;
    }
    public SecretInfos() { }
    public SecretInfos(AddStuInfos addStuInfos,String stuNo) {
        this.faName = addStuInfos.getFaName();
        this.faPhone = addStuInfos.getFaPhone();
        this.moName = addStuInfos.getMoName();
        this.moPhone = addStuInfos.getMoPhone();
        this.address = addStuInfos.getAddress();
        this.stuNo = stuNo;
    }
}