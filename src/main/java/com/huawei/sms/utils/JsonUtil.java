package com.huawei.sms.utils;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtil {



    public static Gson gson;

    static {
        gson = new GsonBuilder()
                //.registerTypeAdapter(new TypeToken<Map<String, Object>>(){}.getType(), new GsonTypeAdapter())
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
    }



    public static Object FromJson(String json, Class c){


        return gson.fromJson(json, c);

    }

    public static String ToJson(Object o){

        return gson.toJson(o);
    }




}
