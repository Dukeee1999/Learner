package com.atguigu.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;

public class WebUtils {
    public static <T> T CopyParamToBean(HttpServletRequest req,T bean){
        try {
            BeanUtils.populate(bean,req.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
    public static int parseInt(String strInt, int defaultValue){
        try{
            return Integer.parseInt(strInt);
        }catch (Exception e){
            e.printStackTrace();
        }
        return defaultValue;
    }
}
