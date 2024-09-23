package cn.dsxriiiii.io;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @PackageName: cn.dsxriiiii.io
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/10 19:37
 * @Description: 字节流
 **/
public class ByteStreamExample {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("C:\\Users\\ASUS\\Desktop\\123.txt")) {
            int byteValue;
            while ((byteValue = fis.read())!= -1) {
                System.out.println((char) byteValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}