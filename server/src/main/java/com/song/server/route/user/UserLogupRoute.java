package com.song.server.route.user;

import com.alibaba.fastjson.JSON;
import com.song.common.code.service.VerifyCodeService;
import com.song.common.exception.AppException;
import com.song.common.user.service.UserService;
import com.song.common.user.vo.UserVo;
import com.song.common.userauth.vo.UserAuthVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.Date;

/**
 * Created by 00013708 on 2017/8/3.
 */
@Service
public class UserLogupRoute implements Route{

    @Autowired
    private UserService userService;
    @Autowired
    private VerifyCodeService verifyCodeService;

    @Override
    public Object handle(Request request, Response response) throws Exception {
        //不搞那么复杂，就搞最简单的，认为就是一个手机号，一个密码，完了。
        //在这之前有2次js的ajax调用，1.生成6位的码；2.验证6位的码；而且这里明显输完就要验证
        String body = request.body();

        if(StringUtils.isEmpty(body)){
            throw new AppException(999999,"body null");
        }
        //注册填写的手机号，邮箱identifier
        UserAuthVo userAuthVo = JSON.parseObject(body,UserAuthVo.class);

        String identity = userAuthVo.getIdentity();
        if(StringUtils.isEmpty(identity)){
            throw new AppException(999999,"identity null");
        }
        String code = userAuthVo.getVerifyCode();

        verifyCodeService.check(identity,code);
        //校验成功后，插入一条数据到用户表和用户认证表
        UserVo userVo = new UserVo();//生成一个10为的userName，可能重复。
        String userName = verifyCodeService.generate(10);
        userVo.setUserName(userName);
        userVo.setPhone(identity);
        userVo.setPassword(userAuthVo.getCredential());
        userVo.setRegisterIp(request.ip());
        userVo.setRegisterTime(new Date());
        userVo.setLoginIp(request.ip());
        userVo.setLoginTime(new Date());

        return null;
    }
}
