package com.nowcoder.community.util;

public class RedisKeyUtil {

    // Redis的key以：分隔单词
    private static final String SPLIT = ":";
    // 某个实体赞的前缀
    private static final String PREFIX_ENTITY_LIKE = "like:entity";
    // 某个用户赞的前缀
    private static final String PREFIX_USER_LIKE = "like:user";
    // 关注的目标
    private static final String PREFIX_FOLLOWEE = "followee";
    // 点关注的人
    private static final String PREFIX_FOLLOWER = "follower";

    // 某个实体的赞
    // like:entity:entityType:entityId -> set(userId) 可能有存谁点的赞之类的功能，所以仅仅一个实数不合适，用SET更好
    public static String getEntityLikeKey(int entityType, int entityId) {
        return PREFIX_ENTITY_LIKE + SPLIT + entityType + SPLIT + entityId;
    }

    // 某个用户的赞
    // like:user:userId -> int
    public static String getUserLikeKey(int userId) {
        return PREFIX_USER_LIKE + SPLIT + userId;
    }

    // 某个用户关注的实体，不一定是人
    // followee:userId:entityType -> zset(entityId,now)
    public static String getFolloweeKey(int userId, int entityType) {
        return PREFIX_FOLLOWEE + SPLIT + userId + SPLIT + entityType;
    }

    // 某个实体拥有的实体粉丝。可以是人的粉丝，也可以是贴的关注者等
    // follower:entityType:entityId -> zset(userId,now)
    public static String getFollowerKey(int entityType, int entityId) {
        return PREFIX_FOLLOWER + SPLIT + entityType + SPLIT + entityId;
    }



}

