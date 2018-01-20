package com.wanban.test;

import com.wanban.dao.FirstLevelMapper;
import com.wanban.dao.SecondLevelMapper;
import com.wanban.pojo.FirstLevel;
import com.wanban.pojo.FirstLevelExample;
import com.wanban.pojo.SecondLevel;
import com.wanban.pojo.SecondLevelExample;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 赖红 on 2018/1/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class MapperTest {
    @Autowired
    FirstLevelMapper firstLevelMapper;

    @Autowired
    SecondLevelMapper secondLevelMapper;


    @Autowired
    SqlSession sqlSession;
    @Test
    public void testCRUD(){
//        System.out.print(firstLevelMapper);
//       firstLevelMapper.insert(new FirstLevel(1,"运动","20180116"));

    }

}
