package com.oglib.spirit.boot.cloud.pms.sys.mapper;

import com.oglib.spirit.boot.cloud.pms.sys.entity.SysUserInf;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface ISysUserMapper extends Mapper<SysUserInf> {
}
