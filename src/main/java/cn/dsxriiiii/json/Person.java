package cn.dsxriiiii.json;

import lombok.Data;

import java.util.List;

/**
 * @PackageName: cn.dsxriiiii.json
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/20 23:11
 * @Description:
 **/
@Data
public class Person {
    private String name;
    private int age;
    private Address address;
    private List<Hobby> hobbies;


    @Data
    public static class Address {
        private String street;
        private String city;
        private String country;

        // 构造函数、getter 和 setter 方法
    }

    @Data
    public static class Hobby {
        private String name;
        private String description;

        // 构造函数、getter 和 setter 方法
    }
}
