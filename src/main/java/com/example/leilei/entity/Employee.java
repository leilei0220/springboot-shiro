package com.example.leilei.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author leilei
 * @since 2019-04-26
 */
@TableName("t_employee")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String username;

    private String realname;

    private String password;

    private String tel;

    private String email;

    private Long dept_id;

    private LocalDate inputtime;

    private Integer state;

    private String union_id;

    private Long tenant_id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getDept_id() {
        return dept_id;
    }

    public void setDept_id(Long dept_id) {
        this.dept_id = dept_id;
    }

    public LocalDate getInputtime() {
        return inputtime;
    }

    public void setInputtime(LocalDate inputtime) {
        this.inputtime = inputtime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getUnion_id() {
        return union_id;
    }

    public void setUnion_id(String union_id) {
        this.union_id = union_id;
    }

    public Long getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(Long tenant_id) {
        this.tenant_id = tenant_id;
    }

    @Override
    public String toString() {
        return "Employee{" +
        "id=" + id +
        ", username=" + username +
        ", realname=" + realname +
        ", password=" + password +
        ", tel=" + tel +
        ", email=" + email +
        ", dept_id=" + dept_id +
        ", inputtime=" + inputtime +
        ", state=" + state +
        ", union_id=" + union_id +
        ", tenant_id=" + tenant_id +
        "}";
    }
}
