package com.nowcoder.community.entity;

import java.util.HashMap;
import java.util.Map;

public class Event {

    // 事件的主题.也标志生产者发布的空间，用于存放消息的位置
    private String topic;
    // 事件的触发人
    private int userId;
    // 记录事件触发在哪个实体上，比如给谁点赞了，给谁评论了
    private int entityType;
    private int entityId;
    private int entityUserId;
    // 增加扩展性，把别的特殊数据记录在map里
    private Map<String, Object> data = new HashMap<>();

    public String getTopic() {
        return topic;
    }

    public Event setTopic(String topic) {
        this.topic = topic;
        return this;
    }

    public int getUserId() {
        return userId;
    }

    public Event setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public int getEntityType() {
        return entityType;
    }

    public Event setEntityType(int entityType) {
        this.entityType = entityType;
        return this;
    }

    public int getEntityId() {
        return entityId;
    }

    public Event setEntityId(int entityId) {
        this.entityId = entityId;
        return this;
    }

    public int getEntityUserId() {
        return entityUserId;
    }

    public Event setEntityUserId(int entityUserId) {
        this.entityUserId = entityUserId;
        return this;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public Event setData(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

}
