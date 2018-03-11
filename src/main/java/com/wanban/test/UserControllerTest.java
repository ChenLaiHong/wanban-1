package com.wanban.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:springmvc.xml"})

@WebAppConfiguration
public class UserControllerTest
{
    protected MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setup()
    {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void getAllCategoryTest() throws Exception
    {
        String responseString = mockMvc.perform
                (
                        get("/user/regist/")
                                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                                .param("username","104423521")
                                .param("password","123456")
                                .param("email","150192@qq.com")
                                .param("phone","776602722")
                ).andDo(print()).andReturn().getResponse().getContentAsString();
        System.out.print("-----返回的json = " + responseString);
    }

    @Test
    public void LoginTest() throws Exception
    {
        String responseString = mockMvc.perform
                (
                        get("/user/login/")
                                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                                .param("username","5151")
                                .param("password","123456")
                ).andDo(print()).andReturn().getResponse().getContentAsString();
        System.out.print("-----返回的json = " + responseString);
    }
}
