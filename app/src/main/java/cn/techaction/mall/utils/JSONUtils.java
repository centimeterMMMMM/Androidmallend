package cn.techaction.mall.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import cn.techaction.mall.pojo.SverResponse;



public class JSONUtils {
    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    public static Gson getGson(){
        return gson;
    }
    public static String toJSON(Object obj){
        return gson.toJson(obj);
    }
    public static <T> T fromJson(String json,Class<T> clz){
        return gson.fromJson(json,clz);
    }

    public static <T> T fromJson(String json,Type type){

        return  gson.fromJson(json,type);
    }
}
