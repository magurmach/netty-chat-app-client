package me.magurmach.netty.chatapp.client;

import io.netty.channel.Channel;
import me.magurmach.netty.chatapp.client.services.ChatClientService;
import me.magurmach.netty.chatapp.client.services.InjectableServiceProvider;
import me.magurmach.netty.chatapp.client.services.RegistrationService;
import me.magurmach.netty.chatapp.client.util.ConfigContainer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Shakib Ahmed on 12/25/17.
 */
public class MainClass {
    private static Logger LOG = LogManager.getLogger(MainClass.class);

    private static ConfigContainer configContainer = ConfigContainer.getInstance();
    private static InjectableServiceProvider injectableServiceProvider = InjectableServiceProvider.getInstance();
    private static RegistrationService registrationService = injectableServiceProvider.getRegistrationService();

    private static Channel startChatClient() throws Exception {
        return ChatClientService.start(configContainer.getServerHost(), configContainer.getServerPort());
    }

    public static void main(String[] args) {
        try {
            Channel channel = startChatClient();
            registrationService.register(channel);
        } catch (Exception e) {
            LOG.error("Chat client couldn't be initiated: {}", e.getMessage());
        }
    }
}
