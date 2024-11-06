package cn.dsxriiiii.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

/**
 * @PackageName: cn.dsxriiiii.json
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/20 23:09
 * @Description:
 **/
public class JsonTest {
    public static void main(String[] args) {
        String json = "{\"name\":\"John\",\"age\":30,\"address\":{\"street\":\"123 Main St\",\"city\":\"Anytown\",\"country\":\"USA\"},\"hobbies\":[{\"name\":\"Reading\",\"description\":\"Enjoys reading various books\"},{\"name\":\"Running\",\"description\":\"Likes to go for runs in the park\"}]}";
        try {
//            Person person = JSONObject.parseObject(json, new TypeReference<Person>() {});
            Person person = JSON.parseObject(json, Person.class);
            System.out.println(person.getClass());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
