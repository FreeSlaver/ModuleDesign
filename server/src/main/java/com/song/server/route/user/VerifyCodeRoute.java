package com.song.server.route.user;

import com.alibaba.fastjson.JSON;
import com.song.common.code.service.VerifyCodeService;
import com.song.common.exception.AppException;
import com.song.common.userauth.vo.UserAuthVo;
import com.song.server.vo.RespVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 * Created by 00013708 on 2017/8/3.
 * 生成手机/邮箱对应的验证码
 */
public class VerifyCodeRoute implements Route {

    @Autowired
    private VerifyCodeService verifyCodeService;
    @Override
    public Object handle(Request request, Response response) throws Exception {
        //妈个逼的，这么简单的东西，都搞不定。流程是：xxx，抽象后成为xxx。
        //注册填写的类型，identityType
        String body = request.body();
        if(StringUtils.isEmpty(body)){
            throw new AppException(33333,"body");
        }
        //注册填写的手机号，邮箱identifier
        UserAuthVo userAuthVo = JSON.parseObject(body,UserAuthVo.class);
        String type = userAuthVo.getIdentityType();
        if(StringUtils.isEmpty(type)){
            throw new AppException(333333,"type");
        }
        String identity = userAuthVo.getIdentity();
        if(StringUtils.isEmpty(identity)){
            throw new AppException(333333,"identity");
        }

        verifyCodeService.send(type,identity);

        return new RespVo();
    }
}
