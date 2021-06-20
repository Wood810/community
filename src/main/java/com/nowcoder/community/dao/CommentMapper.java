package com.nowcoder.community.dao;

import com.nowcoder.community.entity.Comment;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    // 根据实体查询评论
    List<Comment> selectCommentsByEntity(int entityType, int entityId, int offset, int limit);

    // 查询数据条目数
    int selectCountByEntity(int entityType, int entityId);

    // 增加评论，返回行数
    int insertComment(Comment comment);

    // 查询评论
    Comment selectCommentById(int id);

    // 查询某用户写过的评论
    List<Comment> selectCommentsByUser(int userId, int offset, int limit);

    // 查询用户评论数
    int selectCountByUser(int userId);

}
