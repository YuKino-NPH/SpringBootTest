package com.cvte.springboottest1.service.impl;

import com.cvte.springboottest1.entity.UserEntity;
import com.cvte.springboottest1.dto.UserDto;
import com.cvte.springboottest1.mapper.UserMapper;
import com.cvte.springboottest1.service.UserService;
import com.cvte.springboottest1.util.DateUtils;
import com.cvte.springboottest1.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    /**
     * 根据名字查找用户信息
     * @param name 需要查找用户的名称
     * @return 查找到的用户信息
     */
    @Override
    public UserDto getUserByName(String name) {
        UserEntity userEntity = userMapper.selectUserByName(name);
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userEntity,userDto);
        return userDto;
    }

    /**
     * 根据UUID查找用户信息
     * @param uuid UUID信息
     * @return 用户信息
     */
    @Override
    public UserDto getUserByUUID(String uuid) {
        UserEntity userEntity = userMapper.selectUserByUUID(uuid);
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userEntity,userDto);
        return userDto;
    }

    /**
     * 查询所有用户的信息
     * @return 所有用户的信息
     */
    @Override
    public List<UserDto> getUsersAll() {
        List<UserEntity> userEntities = userMapper.selectListAll();
        List<UserDto> userDtos = new ArrayList<>();
        for(UserEntity temp:userEntities){
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(temp,userDto);
            userDtos.add(userDto);
        }
        return userDtos;
    }

    /**
     * 增加用户
     * @param userVo 用户信息
     * @return
     */
    @Override
    public UserDto saveUser(UserVo userVo) {
        userVo.setUuid(UUID.randomUUID().toString());
        userVo.setUpdTime(DateUtils.getDate());
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userVo,userEntity);
        userEntity.setCrtUser(userVo.getUuid());
        userEntity.setCrtName(userVo.getName());
        userEntity.setCrtHost(userVo.getHost());
        userEntity.setCrtTime(DateUtils.getDate());

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userVo,userDto);
        int code=userMapper.insertUser(userEntity);
        return code>0?userDto:null;
    }

    /**
     * 根据UUID删除用户
     * @param uuid 被删除的用户UUID
     * @return 数据库变更行数
     */
    @Override
    public int deleteUserByUUID(String uuid) {
        int code=userMapper.deleteUserByUUID(uuid);
        return code;
    }

    /**
     * 根据UUID修改用户信息
     * @param uuid
     * @param userVo
     * @return 更改后的用户信息
     */
    @Override
    public UserDto updateUserByUUID(String uuid, UserVo userVo) {
        userVo.setUuid(uuid);
        userVo.setUpdTime(DateUtils.getDate());
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userVo,userEntity);
        int code=userMapper.updateUserByUUID(userEntity);
        if(code==0){
            return null;
        }
        UserDto userDto = new UserDto();
        return this.getUserByUUID(uuid);
    }
}
