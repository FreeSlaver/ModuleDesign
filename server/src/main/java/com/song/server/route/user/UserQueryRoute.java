package com.song.server.route.user;

import com.song.common.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 * Created by 00013708 on 2017/8/6.
 */
@Service
public class UserQueryRoute implements Route{
    @Autowired
    private UserService userService;
    @Override
    public Object handle(Request request, Response response) throws Exception {


        return null;
    }
}
