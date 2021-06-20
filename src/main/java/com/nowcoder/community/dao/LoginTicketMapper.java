package com.nowcoder.community.dao;

import com.nowcoder.community.entity.LoginTicket;
import org.apache.ibatis.annotations.*;

@Mapper
// 因为Redis重构，这个组件设置为不推荐使用
@Deprecated
public interface LoginTicketMapper {


    // 通过注解免掉写mapper.xml,直接配置sql
    // 要执行insert方法就使用insert注解
    @Insert({
            "insert into login_ticket(user_id,ticket,status,expired) ",
            "values(#{userId},#{ticket},#{status},#{expired})"
    })
    // 这种方式默认不会自动生成主键，需要配置，生成后的值会注入给一个对象keyProperty = "id"
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertLoginTicket(LoginTicket loginTicket);

    @Select({
            "select id,user_id,ticket,status,expired ",
            "from login_ticket where ticket=#{ticket}"
    })
    LoginTicket selectByTicket(String ticket);

    @Update({
            // script脚本
            "<script>",
            "update login_ticket set status=#{status} where ticket=#{ticket} ",
            // 双引号内需要转义字符
            "<if test=\"ticket!=null\"> ",
            // 只是演示and怎么用，下式为恒等
            "and 1=1 ",
            "</if>",
            "</script>"
    })
    int updateStatus(String ticket, int status);

}
