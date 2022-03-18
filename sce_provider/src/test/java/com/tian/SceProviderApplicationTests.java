package com.tian;

import com.tian.entity.PageResult;
import com.tian.entity.QueryPage;
import com.tian.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SceProviderApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        QueryPage queryPage = new QueryPage(1,5,"女");
        PageResult pageResult = userService.queryPage(queryPage);
        System.out.println("------------------------------------------");
        System.out.println(pageResult.getTotal());
        System.out.println(pageResult.getRows());
    }

}
