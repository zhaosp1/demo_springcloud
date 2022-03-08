package com.example.dataservice.bean.model.part1.p1.demo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: zhaosp1
 * @description: 一个抽象的模板类定义
 * @solution: 编程思想()
 * @version: 1.0
 * @createDate: 2021/11/25 23:03
 */
public abstract class BaseEntity implements Serializable {
    private String id;
    private String desc;
    private Date createTime;
    private String version;
    private String createPerson;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }
}
