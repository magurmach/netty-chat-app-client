package me.magurmach.netty.chatapp.client.initilizer;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import me.magurmach.netty.chatapp.client.handler.ChatClientInboundHandler;

/**
 * Created by Shakib Ahmed on 12/25/17.
 */
public class ChatClientInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline clientPipeline = socketChannel.pipeline();

        clientPipeline.addLast(new ObjectDecoder(ClassResolvers.cacheDisabled(null)));
        clientPipeline.addLast(new ObjectEncoder());

        clientPipeline.addLast(new ChatClientInboundHandler());
    }
}
