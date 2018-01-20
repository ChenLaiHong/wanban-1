package com.wanban.service.impl;

import com.wanban.pojo.FirstLevel;
import com.wanban.service.FirstLevelService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

/**
 * Created by CHLaih on 2018/1/19.
 */
@Component
public class InitComponent implements ServletContextListener,ApplicationContextAware {
    private static ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // TODO Auto-generated method stub
        this.applicationContext=applicationContext;
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext application=servletContextEvent.getServletContext();
        FirstLevelService firstLevelService=(FirstLevelService) applicationContext.getBean("firstLevelService");
        List<FirstLevel> firstLevelCountList=firstLevelService.countList();
        application.setAttribute("firstLevelCountList", firstLevelCountList);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }


}
