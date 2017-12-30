package me.magurmach.netty.chatapp.client.services;

/**
 * Created by Shakib Ahmed on 12/30/17.
 */
public class InjectableServiceProvider {
    private RegistrationService registrationService;

    private InjectableServiceProvider() {
        this.registrationService = new RegistrationService();
    }

    private static InjectableServiceProvider INSTANCE = new InjectableServiceProvider();

    public static synchronized InjectableServiceProvider getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new InjectableServiceProvider();
        }

        return INSTANCE;
    }

    public RegistrationService getRegistrationService() {
        return registrationService;
    }
}
