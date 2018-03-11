package com.wanban.utils;

import com.easemob.server.example.api.impl.EasemobIMUsers;
import io.swagger.client.model.RegisterUsers;
import io.swagger.client.model.User;
import org.junit.Assert;

import java.util.logging.Logger;

/**
 * Created by easemob on 2018/2/21.
 */
public class IMRegisterUtil {


    private static EasemobIMUsers easemobIMUsers = new EasemobIMUsers();

    public static void createUser(com.wanban.pojo.User user) {
        RegisterUsers users = new RegisterUsers();
        User imuser = new User().username(user.getUserName()).password(user.getPassword());
        users.add(imuser);
        Object result = easemobIMUsers.createNewIMUserSingle(users);
        Assert.assertNotNull(result);
    }
}
