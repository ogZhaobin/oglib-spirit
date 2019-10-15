package com.oglib.spirit.boot.cloud.pms.sys.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "sys_user_inf")
@ToString
public class SysUserInf implements Serializable {
    private static final long serialVersionUID = 3040702527546719848L;
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;
    /**
     * 密码
     */
    @Column(name = "user_pwd")
    private String userPwd;
}
