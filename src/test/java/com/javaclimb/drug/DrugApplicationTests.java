package com.javaclimb.drug;

import com.javaclimb.drug.entity.User;
import com.javaclimb.drug.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DrugApplicationTests {

    @Autowired
    private IUserService userservice;

    @Test
    void contextLoads() {
        User user = new User();
        user.setUsername("zhangsan");
        User user1 = userservice.queryUserByUsername(user);
        if(user1 != null){
            System.out.println(user1.getPassword());
        }
    }

}
