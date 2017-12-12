package com.song.common.code.service;

import com.song.common.exception.AppException;

/**
 * Created by 00013708 on 2017/8/3.
 * 验证码服务，发送验证码，校验验证码
 */
public interface VerifyCodeService {

    String generate();

    String generate(int len);

    /**
     * 以何种方式type给谁target发送验证码code
     * @param type 类型，手机，邮件
     * @param to phone/email
     * @param code 验证码
     */
    void send(String type,String to,String code);


    void send(String type,String to);

    void check(String identity, String code) throws AppException;
}
