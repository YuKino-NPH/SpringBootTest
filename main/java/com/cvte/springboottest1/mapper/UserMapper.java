package com.cvte.springboottest1.mapper;

import com.cvte.springboottest1.dto.UserDto;
import com.cvte.springboottest1.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    UserEntity selectUserByName(@Param("name") String name);

    UserEntity selectUserByUUID(String uuid);
    List<UserEntity> selectListAll();


    int insertUser(UserEntity userEntity);

    int deleteUserByUUID(@Param("uuid") String uuid);

    int updateUserByUUID(UserEntity userEntity);


}
