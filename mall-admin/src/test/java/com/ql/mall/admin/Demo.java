package com.ql.mall.admin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.core.userdetails.User;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ql on 2022/11/28
 *
 * @author ql
 */
@RunWith(SpringRunner.class)
public class Demo {

    @Test
    public void test01() {
        User user = (User) User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("user")
                .build();
        System.out.println(user.getPassword());
    }
}
