package com.song.common.user.dao;

import com.song.common.user.vo.UserVo;

public interface UserDao {
    int deleteByPrimaryKey(Long id);

    int insert(UserVo record);

    int insertSelective(UserVo record);

    UserVo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserVo record);

    int updateByPrimaryKey(UserVo record);

    UserVo select(UserVo userVo);
}