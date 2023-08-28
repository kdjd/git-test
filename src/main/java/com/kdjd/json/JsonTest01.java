package com.kdjd.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.Date;

/**
 * @author HeHuan
 */
public class JsonTest01 {

    public static void main(String[] args) {
        String res = "{\n" +
                "\t\"code\": \"0\",\n" +
                "\t\"msg\": \"success\",\n" +
                "\t\"data\": {\n" +
                "\t\t\"total\": 1,\n" +
                "\t\t\"pageSize\": 20,\n" +
                "\t\t\"pageNo\": 1,\n" +
                "\t\t\"list\": [\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"name\": \"张三\",\n" +
                "\t\t\t\t\"age\": 34\n" +
                "\t\t\t}\n" +
                "\t\t]\n" +
                "\t}\n" +
                "}";

        User user1 = new User("张三", 34);
        User user2 = new User("李四", 37);
        DataDTO<User> dto = new DataDTO<>();
        //dto.setPageNo(1);
        //dto.setPageSize(20);
        dto.setTotal(2);
        dto.addToList(user1);
        dto.addToList(user2);
        HikResult<User> r = new HikResult<>();
        r.setCode("0");
        r.setMsg("success");
        r.setData(dto);

        String str = JSON.toJSONString(r);

        System.out.println(str);

        HikResult<User> hikResult = JSONObject.parseObject(res, new TypeReference<HikResult<User>>() {
        });

        System.out.println(new Date());


    }
}
