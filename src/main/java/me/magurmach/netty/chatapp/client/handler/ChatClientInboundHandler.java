package me.magurmach.netty.chatapp.client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import me.magurmach.netty.chatapp.client.services.CmdServices;
import me.magurmach.netty.chatapp.messages.OutgoingServerChatMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Shakib Ahmed on 12/25/17.
 */
public class ChatClientInboundHandler extends SimpleChannelInboundHandler<Object> {
    private static Logger LOG = LogManager.getLogger(ChatClientInboundHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object incomingMsg) throws Exception {
        if (incomingMsg instanceof OutgoingServerChatMessage) {

        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        LOG.error("Error to read message: {}", cause.getMessage());
        ctx.close();
    }
}
