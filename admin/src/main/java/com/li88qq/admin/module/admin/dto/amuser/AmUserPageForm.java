package com.li88qq.admin.module.admin.dto.amuser;

import com.li88qq.db.dto.page.PageForm;

import java.time.LocalDate;

/**
 * 查询用户(后台)
 *
 * @author li88qq
 * @version 1.0 2022/3/30 21:51
 */
public class AmUserPageForm extends PageForm {

    private String username;//用户名
    private String name;//昵称
    private String mobile;//手机号码
    private Integer state;//状态
    private LocalDate loginDateBegin;//登录时间开始
    private LocalDate loginDateEnd;//登录时间结束
    private String loginIp;//登录ip
    private LocalDate createDateBegin;//注册时间开始
    private LocalDate createDateEnd;//注册时间结束

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public LocalDate getLoginDateBegin() {
        return loginDateBegin;
    }

    public void setLoginDateBegin(LocalDate loginDateBegin) {
        this.loginDateBegin = loginDateBegin;
    }

    public LocalDate getLoginDateEnd() {
        return loginDateEnd;
    }

    public void setLoginDateEnd(LocalDate loginDateEnd) {
        this.loginDateEnd = loginDateEnd;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public LocalDate getCreateDateBegin() {
        return createDateBegin;
    }

    public void setCreateDateBegin(LocalDate createDateBegin) {
        this.createDateBegin = createDateBegin;
    }

    public LocalDate getCreateDateEnd() {
        return createDateEnd;
    }

    public void setCreateDateEnd(LocalDate createDateEnd) {
        this.createDateEnd = createDateEnd;
    }
}
