package com.cvte.springboottest1.controller;


import com.cvte.springboottest1.enums.UserResponseEnum;
import com.cvte.springboottest1.util.R;
import com.cvte.springboottest1.dto.UserDto;
import com.cvte.springboottest1.entity.UserEntity;
import com.cvte.springboottest1.service.UserService;
import com.cvte.springboottest1.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 根据名称查询用户信息
     * name 用户名称
     */
    @GetMapping("/user")
    public R getUserByName(@RequestParam("name") String name) {
        UserDto user = userService.getUserByName(name);
        if (user != null)
            return R.success().data(user);
        return R.fail(UserResponseEnum.SELECT_ERROR.getCode(), UserResponseEnum.SELECT_ERROR.getMsg());
    }

    /**
     * 获取所有用户信息
     */
    @GetMapping("/userList")
    public R getUsersAll() {
        List<UserDto> users = userService.getUsersAll();
        if (users != null)
            return R.success().data(users);
        return R.fail(UserResponseEnum.SELECT_ERROR.getCode(), UserResponseEnum.SELECT_ERROR.getMsg());
    }

    /**
     * 保存用户信息
     *
     * @param user 用户信息
     * @return 用户信息，失败返回错误码和错误信息
     */
    @PostMapping("/user")
    public R saveUser(@RequestBody UserVo user) {
        UserDto userDto = userService.saveUser(user);
        if (userDto != null) {
            return R.success().data(userDto);
        } else return R.fail(UserResponseEnum.SAVE_ERROR.getCode(), UserResponseEnum.SAVE_ERROR.getMsg());
    }

    /**
     * @param uuid 需要删除数据的用户UUID
     * @return 删除成功返回code为0
     */
    @DeleteMapping("/user/{uuid}")
    public R deleteUserByUUID(@PathVariable("uuid") String uuid) {
        int code = userService.deleteUserByUUID(uuid);
        if (code > 0) {
            return R.success();
        }
        return R.fail(UserResponseEnum.DELETE_ERROR.getCode(), UserResponseEnum.DELETE_ERROR.getMsg());
    }

    /**
     *
     * @param uuid 需要修改用户的UUID
     * @param userVo 需要修改的内容和修改人的信息
     * @return 修改完成后，新的用户信息
     */
    @PutMapping("/user/{uuid}")
    public R updateUserByUUID(@PathVariable("uuid") String uuid, @RequestBody UserVo userVo) {
        UserDto userDtoNew = userService.updateUserByUUID(uuid, userVo);
        if (userDtoNew != null)
            return R.success().data(userDtoNew);
        return R.fail(UserResponseEnum.UPDATE_ERROR.getCode(), UserResponseEnum.UPDATE_ERROR.getMsg());
    }


}
