package com.lim.test.junit.demo.vo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 普通java类测试
 *
 * @author Lim
 * @since 2020/10/22
 */
@Slf4j
class UserTest {

    @Test
    void testToString() {
        User user = new User(3, "test3", false);
        log.info("{}", user.toString());
        Assertions.assertNotNull(user.toString());
    }

}
