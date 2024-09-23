package cn.dsxriiiii.reflect;

/**
 * @PackageName: cn.dsxriiiii.reflect
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/20 16:24
 * @Description:
 **/
class Teacher {
    private String tea_name;
    private int tea_age;

    public Teacher() {
        System.out.println("teacher class constructor");
    }

    public Teacher(String name, int age) {
        this.tea_age = age;
        this.tea_name = name;
    }
}
