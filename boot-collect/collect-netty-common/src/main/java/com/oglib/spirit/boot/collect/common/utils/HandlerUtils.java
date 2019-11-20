package com.oglib.spirit.boot.collect.common.utils;

import com.oglib.spirit.boot.collect.common.DataHandler;
import com.oglib.spirit.boot.collect.common.annotation.HandlerMapping;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 处理工具类
 * @author og 19.11.18
 *
 */
public class HandlerUtils {

    private static final Map<String, DataHandler> INTERFACE_CACHE = new ConcurrentHashMap<>();

    static {
        List<Class> classes = ClassUtils.getAllClassBySubClass(DataHandler.class,
                true,
                "com.oglib.spirit.boot.collect");
        for(Class clz : classes){
            HandlerMapping annotation = (HandlerMapping)clz.getAnnotation(HandlerMapping.class);
            try {
                INTERFACE_CACHE.put(annotation.value(), (DataHandler) clz.newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }





    public static DataHandler getHandlerInstance(String name) {
        return INTERFACE_CACHE.get(name);
    }
}
