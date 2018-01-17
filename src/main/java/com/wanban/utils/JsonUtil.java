package com.wanban.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

/**
 * Created by 赖红 on 2018/1/17.
 */
public class JsonUtil {
    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 将对象转换成json字符串。
     * <p>Title: pojoToJson</p>
     * <p>Description: </p>
     * @param data
     * @return
     */
    public static String objectToJson(Object data) {
        try {
            String string = MAPPER.writeValueAsString(data);
            return string;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json结果集转化为对象
     *
     * @param jsonData json数据
     * @return
     */
    public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
        try {
            T t = MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 将Json对象字符串转化为Map对象
     * @param jsonStr JSON字符串
     * @return 转换成功返回Map对象，失败则返回null
     */
    public static Map<String, String> JsonToMap(String jsonStr) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> params = objectMapper.readValue(jsonStr,Map.class);
            return params;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将Json对象字符串转化为Map<String, Object>对象
     * @param jsonStr JSON字符串
     * @return 转换成功返回Map对象，失败则返回null
     */
    public static Map<String, Object> readJson2Map(String jsonStr) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> params = objectMapper.readValue(jsonStr,Map.class);
            return params;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将json数据转换成pojo对象list
     * <p>Title: jsonToList</p>
     * <p>Description: </p>
     * @param jsonData
     * @param beanType
     * @return
     */
    public static <T>List<T> jsonToList(String jsonData, Class<T> beanType) {
        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
        try {
            List<T> list = MAPPER.readValue(jsonData, javaType);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
