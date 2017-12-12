package com.song.server.route.user;

import com.alibaba.fastjson.JSON;
import com.song.common.exception.AppException;
import com.song.common.user.service.UserService;
import com.song.common.user.vo.UserVo;
import com.song.server.vo.RespVo;
import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 00013708 on 2017/8/6.
 */
@Service
public class UserLoginRoute implements Route{

    @Autowired
    private UserService userService;

    @Override
    public Object handle(Request request, Response response) throws Exception {
        String body = request.body();
        if(StringUtils.isEmpty(body)){
            throw new AppException(333333,"body");
        }
        Map<String,String> map = JSON.parseObject(body, HashMap.class);
        String type = map.get("type");
        String password = map.get("password");

        if(StringUtils.isEmpty(type)){
            throw new AppException(333333,"type");
        }
        UserVo userParam = new UserVo();
        String pwdMd5 = Md5Crypt.md5Crypt(password.getBytes());
        userParam.setPassword(pwdMd5);
        if(type.equals("phone")){
            String phone = map.get("phone");
            userParam.setPhone(phone);

        }else if(type.equals("email")){
            String email = map.get("email");
            userParam.setEmail(email);
        }else if(type.equals("username")){
            String username = map.get("username");
            userParam.setUserName(username);
        }
        UserVo userVo = userService.find(userParam);
        if(userVo==null){
            throw new AppException(999999,"密码错误");
        }

        //放入session
        String uidAttKey = "user_"+userVo.getId();
        request.session().attribute(uidAttKey,userVo);
        return new RespVo();
    }
}
