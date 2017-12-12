package com.song.server.route.user;

import com.song.server.vo.RespVo;
import org.springframework.stereotype.Service;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 * Created by 00013708 on 2017/8/6.
 */
@Service
public class UserLogoutRoute implements Route {

    @Override
    public Object handle(Request request, Response response) throws Exception {
/*        request.session(true);                     // create and return session
        request.session().attribute("user");       // Get session attribute 'user'
        request.session().attribute("user","foo"); // Set session attribute 'user'
        request.session().removeAttribute("user"); // Remove session attribute 'user'
        request.session().attributes();            // Get all session attributes
        request.session().id();                    // Get session id
        request.session().isNew();                 // Check if session is new
        request.session().raw();                   // Return servlet object
        */
        //得到用户唯一标示id
        String uid = request.queryParams("uid");
        String uidAttKey = "user_"+uid;
        request.session().removeAttribute(uidAttKey);
        return new RespVo();
    }
}
