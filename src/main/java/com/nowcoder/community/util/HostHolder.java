package com.nowcoder.community.util;

import com.nowcoder.community.entity.User;
import org.springframework.stereotype.Component;

/**
 * 起到一个容器的作用，持有用户信息,用于代替session对象.（session对象本身是线程隔离的，只是目前不想使用session对象）
 * 以线程为key存取
 */
@Component
public class HostHolder {

    // 线程局部变量
    private ThreadLocal<User> users = new ThreadLocal<>();

    public void setUser(User user) {
        users.set(user);
    }

    public User getUser() {
        return users.get();
    }

    public void clear() {
        users.remove();
    }

}
