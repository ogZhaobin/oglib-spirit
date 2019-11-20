package com.oglib.spirit.boot.collect.common.utils;


import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.oglib.spirit.boot.collect.experience.model.Frame;
import com.oglib.spirit.boot.collect.experience.model.UserEntity;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class ParseFromUtils {

    private static final Map<String, Method> METHOD_CACHE = new ConcurrentHashMap<>();

    static {
        List<Class> classes = ClassUtils.getAllClassBySubClass(MessageLite.class,
                true, "com.oglib.spirit.boot.collect.experience.model");
        classes.stream()
                .filter(protoClass -> !Objects.equals(protoClass, Frame.class))
                .forEach(protoClass -> {
                    try {
                        //反射获取parseFrom方法并缓存到map
                        METHOD_CACHE.put(protoClass.getSimpleName(), protoClass.getMethod("parseFrom", ByteString.class));
                    } catch (NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    /**
     * 根据Frame类解析出其中的body
     *
     * @param msg
     * @return
     */
    public static MessageLite parse(Frame msg) throws InvocationTargetException, IllegalAccessException {
        System.out.println(msg.getClass().getPackage());
        String type = msg.getMessageName();
        ByteString body = msg.getData();

        Method method = METHOD_CACHE.get(type);
        if (method == null) {
            throw new RuntimeException("unknown Message type :" + type);
        }
        return (MessageLite) method.invoke(null, body);
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InvalidProtocolBufferException {
        UserEntity userEntity = UserEntity.newBuilder().setAge(1).setSex(1).setName("lucy").build().getDefaultInstanceForType();
        Frame msg = Frame.newBuilder().setMessageName("UserEntity")
                .setData(userEntity.toByteString())
                .build().getParserForType().parseFrom(userEntity.toByteString());
        ParseFromUtils.parse(msg);
    }

}
