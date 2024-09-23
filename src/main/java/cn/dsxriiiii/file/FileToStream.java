package cn.dsxriiiii.file;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/**
 * @PackageName: cn.dsxriiiii.file
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/21 16:34
 * @Description: 操作文件
 **/
public class FileToStream {
    public static void main(String[] args) throws IOException {
        //read();
        write();
    }

    /**
     * 读文件操作
     * @throws IOException io异常
     */
    public static void read() throws IOException {
        File file = new File("C:\\Users\\ASUS\\Desktop\\豆包脚本.txt");
        InputStream inputStream = Files.newInputStream(file.toPath());
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        char[] result = new char[1024];
        //byte字符转换为char
        while (true){
            int len = inputStreamReader.read(result);
            if(len==-1){
                break;
            }
            for (int i = 0; i <len; i++) {
                System.out.print(result[i]);
            }
        }
        inputStream.close();
    }

    public static void write() {
        File file = new File("C:\\Users\\ASUS\\Desktop\\豆包脚本.txt");
        try(FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8)){
            outputStreamWriter.write("你不是豆包你是谁" + "\n");
            System.out.println("文件写入成功");

        }catch (IOException e){
            System.out.println("写入异常" + e.getMessage());
        }
    }
}
