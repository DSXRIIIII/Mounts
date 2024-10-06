package cn.dsxriiiii.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @PackageName: cn.dsxriiiii.io.nio
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/28 17:31
 * @Description: NIOServer
 **/
public class NIOServer {
    public static void main(String[] args) throws IOException {
        // 创建 ServerSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        // 设置为非阻塞模式
        serverSocketChannel.configureBlocking(false);
        System.out.println("服务器启动，监听端口 8080...");
        while (true) {
            // 等待客户端连接
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel!= null) {
                handleClient(socketChannel);
            }
        }
    }

    private static void handleClient(SocketChannel socketChannel) throws IOException {
        System.out.println("客户端连接：" + socketChannel.getRemoteAddress());
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (socketChannel.read(buffer)!=-1) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.print((char) buffer.get());
            }
            buffer.clear();
        }
        socketChannel.close();
    }
}
