package com.song.common.user.service;

import com.song.common.user.vo.UserVo;

/**
 * Created by 00013708 on 2017/8/3.
 */

public interface UserService {


    UserVo find(UserVo userVo);

    int add(UserVo userVo);
}
