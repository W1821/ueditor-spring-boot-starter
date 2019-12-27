package org.humki.baiduueditor.util;

import com.alibaba.fastjson.JSONObject;

/**
 * json字符串工具类
 *
 * @author Kael
 */
public class JsonUtil {

    /**
     * 对象转json字符串
     *
     * @param obj 对象
     * @return json字符串
     */
    public static String objToJsonString(Object obj) {
        return JSONObject.toJSONString(obj);
    }


}
