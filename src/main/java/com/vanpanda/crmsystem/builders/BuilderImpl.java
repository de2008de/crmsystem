package com.vanpanda.crmsystem.builders;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.alibaba.fastjson.JSONObject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Use provided params and a Class object to build an instance of 
 * specified type.
 * 
 * @return an instance built with params
 * @author David Chou
 */
@Component
@Qualifier(value = "BuilderImpl")
public class BuilderImpl implements Builder {
    public <T> T buildWithParams(Class<T> clazz, JSONObject params) {
        try {
            Field[] fields = clazz.getDeclaredFields();
            T instance = clazz.newInstance();

            for (Field field : fields) {
                String fieldName = field.getName();
                String typeName = field.getType().getSimpleName();
                String setterName = getSetterName(fieldName);

                if (params.get(fieldName) == null) {
                    continue;
                }

                Method setter = null;

                try {

                    setter = clazz.getMethod(setterName, field.getType());

                } catch (Exception e) {

                    e.printStackTrace();
                    continue;

                }

                if (typeName.equals("int") || typeName.equals("Integer")) {
                    setter.invoke(instance, params.getIntValue(fieldName));
                } else if (typeName.equals("boolean") || typeName.equals("Boolean")) {
                    setter.invoke(instance, params.getBoolean(fieldName));
                } else if (typeName.equals("String")) {
                    setter.invoke(instance, params.getString(fieldName));
                } else if (typeName.equals("Date")) {
                    setter.invoke(instance, params.getDate(fieldName));
                } else if (typeName.equals("Double") || typeName.equals("double")) {
                    setter.invoke(instance, params.getDouble(fieldName));
                } else if (typeName.equals("Float") || typeName.equals("float")) {
                    setter.invoke(instance, params.getFloat(fieldName));
                } else if (typeName.equals("Short") || typeName.equals("short")) {
                    setter.invoke(instance, params.getShort(fieldName));
                } else if (typeName.equals("Long") || typeName.equals("long")) {
                    setter.invoke(instance, params.getLong(fieldName));
                } else if (typeName.equals("Byte") || typeName.equals("byte")) {
                    setter.invoke(instance, params.getByte(fieldName));
                }
            }

            return instance;
            
        } catch (Exception e) {

                e.printStackTrace();
                return null;

        }
    }

    private String getSetterName(String fieldName) {
        return "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
    }
}
