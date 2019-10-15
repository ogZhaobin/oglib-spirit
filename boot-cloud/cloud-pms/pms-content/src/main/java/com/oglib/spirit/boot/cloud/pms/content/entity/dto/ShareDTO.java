package com.oglib.spirit.boot.cloud.pms.content.entity.dto;

import com.oglib.spirit.boot.cloud.pms.content.entity.ContentInf;
import lombok.Data;

import java.io.Serializable;

@Data
public class ShareDTO implements Serializable {
    private static final long serialVersionUID = 7561467143366334918L;

    private ContentInf content;

    private SysUserDTO userDTO;

}
