package com.oglib.spirit.boot.cloud.pms.content.mapper;

import com.oglib.spirit.boot.cloud.pms.content.entity.ContentInf;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

@Repository
public interface IContentMapper extends BaseMapper<ContentInf> {
}
