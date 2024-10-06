package cn.dsxriiiii.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @PackageName: cn.dsxriiiii.io.nio
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/28 17:32
 * @Description: NIOClient
 **/
public class NIOClient {
    public static void main(String[] args) throws IOException {
        // 创建 SocketChannel
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 8080));
        // 设置为非阻塞模式
        socketChannel.configureBlocking(false);
        String message = "Hello, NIO Server!";
        ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
        socketChannel.write(buffer);
        socketChannel.close();
    }
}
