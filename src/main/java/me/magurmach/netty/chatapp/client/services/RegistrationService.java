package me.magurmach.netty.chatapp.client.services;

import io.netty.channel.Channel;
import me.magurmach.netty.chatapp.client.util.ConfigContainer;
import me.magurmach.netty.chatapp.messages.RegistrationRequestMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/**
 * Created by Shakib Ahmed on 12/30/17.
 */
public class RegistrationService {
    private static Logger LOG = LogManager.getLogger(RegistrationService.class);

    private BufferedReader in;
    private ConfigContainer configContainer = ConfigContainer.getInstance();

    public RegistrationService() {
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    private String getUserHandle() {
        CmdServices.show("Please input the handle you want to use: ");
        String handle;
        while(true) {
            try {
                handle = in.readLine();
                if (Pattern.matches(configContainer.getHandlePattern(), handle)) {
                    break;
                }
            } catch (IOException e) {
                LOG.error("Error reading handler: {}", e.getMessage());
            }
            CmdServices.show("Expecting handle that matches regex " + configContainer.getHandlePattern() +
                            ". Please try again: ");
        }

        return handle;
    }

    private RegistrationRequestMessage getRegistrationMessage() {
        String handle = getUserHandle();
        RegistrationRequestMessage registrationRequestMessage = new RegistrationRequestMessage();
        registrationRequestMessage.setUserHandle(handle);
        return registrationRequestMessage;
    }

    public void register(Channel channelToServer) {
        RegistrationRequestMessage registrationRequestMessage = getRegistrationMessage();
        channelToServer.writeAndFlush(registrationRequestMessage);
    }
}
