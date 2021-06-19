package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    // userId是将来功能使用的（如查看自己的贴子），在首页查询的时候用不到这个参数，可以利用userId是否为0进行区分
    // mapper.xml只需要声明sql返回的类型DiscussPost，JAVA会自动检测List结构
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    // 查询一共有多少行帖子数据
    // @Param注解用于给参数取别名，比如有的名字很长
    // 如果只有一个参数，且需要动态的拼接一个条件，并且在动态sql <if>标签里使用,则必须加别名，否则会报错
    int selectDiscussPostRows(@Param("userId") int userId);


    // 增加帖子
    int insertDiscussPost(DiscussPost discussPost);

    // 查看帖子。方法返回帖子
    DiscussPost selectDiscussPostById(int id);

    // 增加或者删除评论更新评论数量
    int updateCommentCount(int id, int commentCount);

}

