package com.song.common.user.service.impl;

import com.song.common.user.dao.UserDao;
import com.song.common.user.service.UserService;
import com.song.common.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 00013708 on 2017/8/6.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public UserVo find(UserVo userVo){
      return  userDao.select(userVo);
    }

    public int add(UserVo userVo){
        return userDao.insert(userVo);
    }
}
