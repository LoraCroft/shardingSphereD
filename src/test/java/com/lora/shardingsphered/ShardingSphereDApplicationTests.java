package com.lora.shardingsphered;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lora.shardingsphered.entity.Course;
import com.lora.shardingsphered.mapper.CourseMapper;
import org.apache.shardingsphere.api.hint.HintManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ShardingSphereDApplicationTests {
    @Resource
    CourseMapper courseMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void addCourse(){
//        for (int i = 0; i < 10; i++) {
//            Course course = new Course();
//            //course.setCid(Long.valueOf(i));
//            course.setCname("shardingSphere"+i);
//            course.setUserId(Long.valueOf(1000+i));
//            course.setCstatus("1");
//
//            courseMapper.insert(course);
//        }
    }

    @Test
    void queryCourse(){
        //定制查询逻辑
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("cid");

        wrapper.between("cid",749045949292089344L,749045962281848833L);

        wrapper.eq("user_id",1005L);

//        wrapper.last("limit 3");

        //可以链式调用:
//        wrapper
//                .between("cid",749045949292089344L,749045962281848833L)
//                .orderByDesc("cid")
//                .eq("user_id",123);




        List<Course> courses = courseMapper.selectList(wrapper);
        courses.forEach(System.out::println);
    }

    @Test
    public void queryCourseByHint(){
        HintManager hintManager = HintManager.getInstance();
        hintManager.addDatabaseShardingValue("m","1");
        hintManager.addTableShardingValue("course","1");
    }

}
