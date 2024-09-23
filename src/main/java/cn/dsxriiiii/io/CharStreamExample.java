package cn.dsxriiiii.io;

import java.io.FileReader;
import java.io.IOException;

/**
 * @PackageName: cn.dsxriiiii.io
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/10 19:40
 * @Description: 字符流
 **/
public class CharStreamExample {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("C:\\Users\\ASUS\\Desktop\\123.txt")) {
            int charValue;
            while ((charValue = fr.read())!= -1) {
                System.out.print((char) charValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
