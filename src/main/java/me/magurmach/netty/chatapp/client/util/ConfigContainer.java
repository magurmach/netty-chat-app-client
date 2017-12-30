package me.magurmach.netty.chatapp.client.util;

/**
 * Created by Shakib Ahmed on 12/26/17.
 */
public class ConfigContainer {
    private String chatEndDelimiter;
    private String serverHost;
    private int serverPort;
    private String handlePattern;


    private ConfigContainer() {
        this.chatEndDelimiter = DefaultsAndConstants.DEFAULT_CHAT_END_LIMITER;
        this.serverHost = DefaultsAndConstants.DEFAULT_HOST;
        this.serverPort = DefaultsAndConstants.DEFAULT_PORT;
        this.handlePattern = DefaultsAndConstants.HANDLE_PATTERN;
    }

    private static ConfigContainer configContainer = null;

    public static synchronized ConfigContainer getInstance() {
        if (configContainer == null) {
            configContainer = new ConfigContainer();
        }

        return configContainer;
    }

    public String getChatEndDelimiter() {
        return chatEndDelimiter;
    }

    public void setChatEndDelimiter(String chatEndDelimiter) {
        this.chatEndDelimiter = chatEndDelimiter;
    }

    public String getServerHost() {
        return serverHost;
    }

    public void setServerHost(String serverHost) {
        this.serverHost = serverHost;
    }

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    public String getHandlePattern() {
        return handlePattern;
    }

    public void setHandlePattern(String handlePattern) {
        this.handlePattern = handlePattern;
    }
}
