package com.oglib.spirit.boot.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

/**
 * spring bean 处理类
 * @author og 19.11.13
 */
@Slf4j
@Configuration
public class SpringBeanHolderUtils implements ApplicationContextAware, DisposableBean {

    private static ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }

    public static <T> T getBean(Class<T> clz){
        return clz == null ? null : ctx.getBean(clz);
    }

    public static Object getBean(String name){
        return StringUtils.isEmpty(name) ? null : ctx.getBean(name);
    }

    @Override
    public void destroy() throws Exception {
        log.debug("释放ApplicationContext对象");
        ctx = null;
    }
}
