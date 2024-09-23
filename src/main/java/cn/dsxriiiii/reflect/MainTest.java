package cn.dsxriiiii.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

/**
 * @PackageName: cn.dsxriiiii.reflect
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/20 16:12
 * @Description: 反射
 **/
public class MainTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Student student = new Student("张三",12);
        Class<? extends Student> clazz = student.getClass();
        System.out.println("反射获取类名："+clazz.getName());
        System.out.println("反射获取父类名："+clazz.getSuperclass().getName());
        System.out.println("反射判断修饰符是否为public："+ Modifier.isPublic(clazz.getModifiers()));
        Constructor<? extends Student> constructor = clazz.getConstructor();
        Constructor<? extends Student> new_constructor = clazz.getConstructor(String.class,int.class);
        Student instance_student_1 = constructor.newInstance();
        Student instance_student_2 = new_constructor.newInstance("李四", 123);
        Field number = clazz.getDeclaredField("number");
        number.setAccessible(true);
        number.set(null,"567890");
        number.setAccessible(false);
        System.out.println("修改后的静态字段为:" + student.getNumber());
    }
}

