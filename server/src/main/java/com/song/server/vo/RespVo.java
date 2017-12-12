package com.song.server.vo;

import com.alibaba.fastjson.JSON;

import java.util.Date;

/**
 * Created by 00013708 on 2017/8/3.
 */
public class RespVo {

    private int code;

    private String msg;

    private Object data;

    private Date timestamp;

    public RespVo() {
        this.code = 0;
        this.msg="success";
        this.timestamp=new Date();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
