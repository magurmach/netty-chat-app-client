package me.magurmach.netty.chatapp.client.services;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import me.magurmach.netty.chatapp.client.initilizer.ChatClientInitializer;

/**
 * Created by Shakib Ahmed on 12/25/17.
 */
public class ChatClientService {

    public static Channel start(String host, int port) throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap clientBootstrap = new Bootstrap();

        clientBootstrap
                .group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChatClientInitializer());

        Channel channel = clientBootstrap.connect(host, port).sync().channel();

        return channel;
    }
}
