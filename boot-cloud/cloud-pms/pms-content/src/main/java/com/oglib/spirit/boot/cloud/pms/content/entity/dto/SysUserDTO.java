package com.oglib.spirit.boot.cloud.pms.content.entity.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysUserDTO implements Serializable {
    private static final long serialVersionUID = 2849755512310688363L;

    private Integer id;

    private String userName;

    private String userPwd;

}
