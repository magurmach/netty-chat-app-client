package me.magurmach.netty.chatapp.client.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Shakib Ahmed on 12/30/17.
 */
public class QueueStatus {
    HashMap<String, Integer> handleToQueueSizeMap;

    public QueueStatus() {
        handleToQueueSizeMap = new HashMap<>();
    }

    public void add(String handle, int queueSize) {
        handleToQueueSizeMap.put(handle, queueSize);
    }

    public Set<Map.Entry<String, Integer>> get() {
        return handleToQueueSizeMap.entrySet();
    }
}
