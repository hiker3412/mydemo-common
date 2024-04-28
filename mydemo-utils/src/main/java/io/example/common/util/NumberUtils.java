package io.example.common.util;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Slf4j
public class NumberUtils {

    public static String getBigAmountUnit(Double aDouble){
        String unit = "";
        if (aDouble == null) {
            return unit;
        } else if (aDouble < 10000) {
            unit = "元";
        } else
        if (aDouble < 100000000) {
            unit = "万";
        } else {
            unit = "亿";
        }
        return unit;
    }
    public static Long getBigAmountValue(Double aDouble){
        if (aDouble == null) {
            return null;
        }
        Double value = null;
        if (aDouble < 10000) {
            value = aDouble;
        } else
        if (aDouble < 100000000) {
            value = aDouble / 10000;
        } else {
            value = aDouble / 100000000;
        }
        return (long)Math.ceil(value);
    }

    public static <T> T objSubtract(T o1, T o2) {
        try {
            Field[] o1Fields = o1.getClass().getDeclaredFields();
            T result = (T) o1.getClass().getConstructor().newInstance();
            for (Field field : o1Fields) {
                String getName = "get" + StringUtils.capitalize(field.getName());
                Method getMethod = o1.getClass().getDeclaredMethod(getName);
                Object o1Val = getMethod.invoke(o1);
                if (!(o1Val instanceof Number)) {
                    continue;
                }
                Object o2Val = getMethod.invoke(o2);
                Number o1Num = o1Val == null ? 0 : (Number) o1Val;
                Number o2Num = o2Val == null ? 0 : (Number) o2Val;
                String setName = "set" + StringUtils.capitalize(field.getName());
                Method setMethod = o1.getClass().getDeclaredMethod(setName);
                Number diff = 0;
                if (o1Num instanceof Double) {
                    diff = o1Num.doubleValue() - o2Num.doubleValue();
                    setMethod.invoke(result, diff);
                    return result;
                }
            }
        } catch (Exception e) {
            log.error("对象相减出错", e);
        }
        return null;
    }
}
