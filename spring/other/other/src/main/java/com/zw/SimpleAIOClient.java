package com.zw;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.TimeUnit;

public class SimpleAIOClient {

    public static void main(String[] args) {
        try {
            // 打开一个SocketChannel通道并获取AsynchronousSocketChannel实例
            AsynchronousSocketChannel client = AsynchronousSocketChannel.open();
            // 连接到服务器并处理连接结果
            client.connect(new InetSocketAddress("127.0.0.1", 5555),
                    null, new CompletionHandler<Void, Void>() {
                @Override
                public void completed(final Void result, final Void attachment) {
                    System.out.println("成功连接到服务器!");
                    try {
                        // 给服务器发送信息并等待发送完成
                        client.write(ByteBuffer.wrap("From client:Hello i am client".getBytes()))
                                .get();
                        ByteBuffer readBuffer = ByteBuffer.allocate(128);
                        // 阻塞等待接收服务端数据
                        client.read(readBuffer)
                                .get();
                        System.out.println(new String(readBuffer.array()));
                    } catch ( Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void failed(final Throwable exc, final Void attachment) {
                    exc.printStackTrace();
                }
            });
            TimeUnit.MINUTES.sleep(Integer.MAX_VALUE);
        } catch ( Exception e) {
            e.printStackTrace();
        }
    }
}