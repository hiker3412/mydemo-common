package io.hiker.common.util;

import org.apache.commons.lang3.ObjectUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ObjUtils {
    public static boolean  equals(Object o1,Object o2){
        if (o1 == null && o2 == null) {
            return true;
        }
        if (o1 != null && o2 != null) {
            if (o1.equals(o2)) {
                return true;
            }

            Class<?> o1Class = o1.getClass();
            Class<?> o2Class = o2.getClass();
            Field[] o1Fields = o1Class.getDeclaredFields();
            for (Field o1Field : o1Fields) {
                try {
                    String getMethodName = "get" + StringUtils.capitalize(o1Field.getName());
                    Method o1Method = o1Class.getDeclaredMethod(getMethodName);
                    Method o2Method = o2Class.getDeclaredMethod(getMethodName);
                    Object o1Value = o1Method.invoke(o1);
                    Object o2Value = o2Method.invoke(o2);
                    if (ObjectUtils.notEqual(o1Value,o2Value)){
                        return false;
                    }
                } catch (NoSuchMethodException ignored) {
                } catch (InvocationTargetException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            return true;
        }
        return false;
    }
}
