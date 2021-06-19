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

}
