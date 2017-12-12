package com.song.common.code.service.impl;

import com.song.common.code.service.VerifyCodeService;
import com.song.common.email.service.EmailService;
import com.song.common.exception.AppException;
import com.song.common.redis.RedisService;
import com.song.common.sms.service.SmsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by 00013708 on 2017/8/3.
 */
@Service
public class VerifyCodeServiceImpl implements VerifyCodeService{

    @Autowired
    private EmailService emailService;
    @Autowired
    private SmsService smsService;
    @Autowired
    private RedisService<String,String> redisService;

    private static final Random RANDOM = new Random(47);
    //不对，我TM应该自己想想，这个地方不用特定的名称，
    //6位数字码生成
    public String  generate(){
        return generateNoCode(6);
    }

    public String generate(int len){
        return generateNoCode(len);
    }

    /**
     * 生成len长度的数字码
     * @param len
     * @return
     */
    private String generateNoCode(int len){
        if(len<=0){
            return null;
        }
        StringBuilder sb = new StringBuilder(len);
        for(int i=0;i<len;i++){
            sb.append(RANDOM.nextInt(10));
        }
        return sb.toString();
    }

    //码长度配置在外面
    @Override
    public void send( String type,String to, String code) {
        //将手机号/邮箱和码绑定到redis中
        //这个地方可以封装到一个类里面去，发送验证码服务，传2个参数，一个什么类型，一个码。
        long timeout = 0;
        if(type.equals("email")){
            //发送邮件验证码
            emailService.sendEmail(to,code);
            timeout = 60*5;
        }else if(type.equals("phone")){
            //发送手机短信验证码
            smsService.sendSms(to,code);
            timeout = 60;
        }else if(type.equals("weixin")){//weixin什么的。。

        }
        redisService.put(to,code,timeout, TimeUnit.SECONDS);
    }

    @Override
    public void send(String type, String to) {
        send(type,to,generate()) ;
    }

    @Override
    public void check(String identity, String code) throws AppException {
        String codeStr = redisService.get(identity);

        if(StringUtils.isEmpty(codeStr)){
            throw new AppException(999999,"验证码已失效");
        }
        if(!codeStr.equals(code)){
            throw new AppException(999999,"验证码错误");
        }
    }
}
