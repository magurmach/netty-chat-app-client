package me.magurmach.netty.chatapp.client.services;

import me.magurmach.netty.chatapp.client.models.QueueStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Shakib Ahmed on 12/25/17.
 */
public class CmdServices {

    public static synchronized void showIncomingMessage(String formattedMessage) {
        System.out.println(formattedMessage);
    }

    public static synchronized void show(String str) {
        System.out.printf("%s\n> ", str);
    }

    public static synchronized void show(List<String> strList) {
        for (String str: strList) {
            System.out.println(str);
        }
        System.out.printf("> ");
    }

    public static synchronized void showIncomingMessage(String sourceHandle, String message) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[").append(sourceHandle).append("] - ").append(message);
        showIncomingMessage(stringBuilder.toString());
    }

    public static synchronized void showStatus(QueueStatus queueStatus) {
        List<String> strList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry: queueStatus.get()) {
            strList.add(entry.getKey() + "(" + entry.getValue() + ")");
        }

        show(strList);
    }
}
