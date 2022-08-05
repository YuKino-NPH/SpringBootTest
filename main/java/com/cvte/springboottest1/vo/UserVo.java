package com.cvte.springboottest1.vo;

import com.cvte.springboottest1.validGroup.AddGroup;
import com.cvte.springboottest1.validGroup.UpdateGroup;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

public class UserVo {
    private String uuid;
    @NotBlank(message = "姓名不能为空",groups = {AddGroup.class})
    private String name;
    @NotBlank(message = "密码不能为空",groups = {AddGroup.class})
    private String password;
    @NotBlank(message = "手机号不能为空",groups = {AddGroup.class})
    @Length(min = 11,max = 11,message = "手机号长度错误",groups = {AddGroup.class})
    private String phone;
    @NotBlank(message = "地址不能为空",groups ={AddGroup.class})
    private String address;
    @NotBlank(message = "主机地址不能为空",groups = {AddGroup.class})
    private String host;
    @NotBlank(message = "修改人UUID不能为空",groups = {UpdateGroup.class})
    private String updUser;
    @NotBlank(message = "修改人姓名不能为空",groups = {UpdateGroup.class})
    private String updName;
    @NotBlank(message = "修改人主机地址不能为空",groups = UpdateGroup.class)
    private String updHost;
    private Date updTime;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUpdUser() {
        return updUser;
    }

    public void setUpdUser(String updUser) {
        this.updUser = updUser;
    }

    public String getUpdName() {
        return updName;
    }

    public void setUpdName(String updName) {
        this.updName = updName;
    }

    public String getUpdHost() {
        return updHost;
    }

    public void setUpdHost(String updHost) {
        this.updHost = updHost;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", host='" + host + '\'' +
                ", updUser='" + updUser + '\'' +
                ", updName='" + updName + '\'' +
                ", updHost='" + updHost + '\'' +
                ", updTime=" + updTime +
                '}';
    }
}
