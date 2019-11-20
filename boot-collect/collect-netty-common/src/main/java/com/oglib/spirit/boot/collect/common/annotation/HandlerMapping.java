package com.oglib.spirit.boot.collect.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *用于映射消息处理handler类型
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface HandlerMapping {
    /**
     * protobuf 文件中的data类型
     * @return DataType
     */
    String value();
}
