package com.userLogin.entity.sysuser;

import java.util.Date;

public class SysUser {
    private Integer id;

    private String username;

    private String realname;

    private String password;

    private Date createdate;

    private Date lastlogintime;

    private Boolean enabled;

    private Boolean credentialsnonexpired;

    private Boolean accountnonexpired;

    private Boolean accountnonlocked;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getCredentialsnonexpired() {
        return credentialsnonexpired;
    }

    public void setCredentialsnonexpired(Boolean credentialsnonexpired) {
        this.credentialsnonexpired = credentialsnonexpired;
    }

    public Boolean getAccountnonexpired() {
        return accountnonexpired;
    }

    public void setAccountnonexpired(Boolean accountnonexpired) {
        this.accountnonexpired = accountnonexpired;
    }

    public Boolean getAccountnonlocked() {
        return accountnonlocked;
    }

    public void setAccountnonlocked(Boolean accountnonlocked) {
        this.accountnonlocked = accountnonlocked;
    }
}