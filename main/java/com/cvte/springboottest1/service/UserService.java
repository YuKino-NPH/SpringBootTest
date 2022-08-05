package com.cvte.springboottest1.service;

import com.cvte.springboottest1.dto.UserDto;
import com.cvte.springboottest1.entity.UserEntity;
import com.cvte.springboottest1.vo.UserVo;

import java.util.List;


public interface UserService {
    UserDto getUserByName(String name);

    UserDto getUserByUUID(String uuid);

    List<UserDto> getUsersAll();

    UserDto saveUser(UserVo user);

    int deleteUserByUUID(String uuid);

    UserDto updateUserByUUID(String uuid, UserVo userVo);
}
