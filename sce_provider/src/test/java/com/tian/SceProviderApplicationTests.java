package com.tian;

import com.tian.mapper.SchoolMapper;
import com.tian.service.SchoolService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SceProviderApplicationTests {

    @Autowired
    private SchoolMapper schoolMapper;

    @Autowired
    private SchoolService schoolService;

    @Test
    void contextLoads2() {
        System.out.println("-----------------------------------------");
        System.out.println(schoolService.findAll());
        System.out.println("-----------------------------------------");
    }
}
