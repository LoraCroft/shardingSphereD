package com.lora.shardingsphered;

import com.lora.shardingsphered.entity.CourseEntity;
import com.lora.shardingsphered.mapper.CourseMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ShardingSphereDApplicationTests {
    @Resource
    CourseMapper courseMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void addCourse(){
        for (int i = 0; i < 10; i++) {
            CourseEntity course = new CourseEntity();
            course.setCid(Long.valueOf(i));
            course.setCname("shardingSphere"+i);
            course.setUserId(Long.valueOf(1000+i));
            course.setCstatus("1");

            courseMapper.insert(course);
        }
    }

}
