package com.wxj.java8learn.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

/**
 *  测试json
 */
public class TestJson {

    @Test
    public void  test01(){
        String jsonStr = "{\n" +
                "    \"id\": \"1\",\n" +
                "    \"userName\": \"wangxj71\",\n" +
                "    \"version\": 1,\n" +
                "    \"userId\": \"1\",\n" +
                "    \"sceneInfos\": {\n" +
                "        \"FCM-FORM-CUSTOMIZE\": {\n" +
                "            \"sysCode\": \"FCM\",\n" +
                "            \"sceneInfo\": \"{\\\"表格定制\\\": \\\"表格定制\\\"}\",\n" +
                "            \"sceneCode\": \"FCM-FORM-CUSTOMIZE\",\n" +
                "            \"sceneName\": \"表格定制\",\n" +
                "            \"sysName\": \"财务影像档案管理系统\",\n" +
                "            \"userVersionId\": \"1\",\n" +
                "            \"id\": \"2\"\n" +
                "        }\n" +
                "    }\n" +
                "}";


        JSONArray objects = JSONObject.parseArray(jsonStr);

    }
}
