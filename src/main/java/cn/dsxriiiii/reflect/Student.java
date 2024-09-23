package cn.dsxriiiii.reflect;

/**
 * @PackageName: cn.dsxriiiii.reflect
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/20 16:24
 * @Description:
 **/
class Student extends Teacher {
    private static String number = "2105110014";
    private String stu_name;
    private int stu_age;

    public Student() {
        System.out.println("student无参构造函数调用");
    }

    public Student(String name, int age) {
        System.out.println("student有参构造函数调用");
        this.stu_age = age;
        this.stu_name = name;
    }

    public String getName() {
        return stu_name;
    }

    public void setName(String stu_name) {
        this.stu_name = stu_name;
    }

    public int getAge() {
        return stu_age;
    }

    public void setAge(int stu_age) {
        this.stu_age = stu_age;
    }

    public String getNumber(){
        return number;
    }
}
