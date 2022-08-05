package com.cvte.springboottest1.controller;


import com.cvte.springboottest1.enums.UserResponseEnum;
import com.cvte.springboottest1.exception.CustomGlobalException;
import com.cvte.springboottest1.exception.VerificationException;
import com.cvte.springboottest1.util.BindingResultCustomUtils;
import com.cvte.springboottest1.validGroup.AddGroup;
import com.cvte.springboottest1.validGroup.UpdateGroup;
import com.cvte.springboottest1.vo.ResultVo;
import com.cvte.springboottest1.dto.UserDto;
import com.cvte.springboottest1.service.UserService;
import com.cvte.springboottest1.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResultUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResultVo getUserByName(@RequestParam("name") String name) {
        UserDto user = userService.getUserByName(name);
        if (user != null)
            return ResultVo.success().data(user);
        throw new CustomGlobalException(UserResponseEnum.SELECT_ERROR.getCode(), UserResponseEnum.SELECT_ERROR.getMsg());
    }

    /**
     * 获取所有用户信息
     */
    @GetMapping("/userList")
    public ResultVo getUsersAll() {
        List<UserDto> users = userService.getUsersAll();
        if (users != null)
            return ResultVo.success().data(users);
         throw new CustomGlobalException(UserResponseEnum.SELECT_ERROR.getCode(), UserResponseEnum.SELECT_ERROR.getMsg());
    }

    /**
     * 保存用户信息
     *
     * @param user 用户信息
     * @return 用户信息，失败返回错误码和错误信息
     */
    @PostMapping("/user")
    public ResultVo saveUser(@Validated(AddGroup.class) @RequestBody UserVo user, BindingResult result) throws VerificationException {
        if (result.hasErrors()) {
            Map<String, String> map = BindingResultCustomUtils.resultToMap(result);
            throw new VerificationException(UserResponseEnum.VERIFICATION_ERROR.getCode(), map);
        }
        UserDto userDto = userService.saveUser(user);
        if (userDto != null) {
            return ResultVo.success().data(userDto);
        }
        throw new CustomGlobalException(UserResponseEnum.SAVE_ERROR.getCode(), UserResponseEnum.SAVE_ERROR.getMsg());
    }

    /**
     * @param uuid 需要删除数据的用户UUID
     * @return 删除成功返回code为0
     */
    @DeleteMapping("/user/{uuid}")
    public ResultVo deleteUserByUUID(@PathVariable("uuid") String uuid) {
        int code = userService.deleteUserByUUID(uuid);
        if (code > 0) {
            return ResultVo.success();
        }
        throw new CustomGlobalException(UserResponseEnum.DELETE_ERROR.getCode(), UserResponseEnum.DELETE_ERROR.getMsg());
    }

    /**
     *
     * @param uuid 需要修改用户的UUID
     * @param userVo 需要修改的内容和修改人的信息
     * @return 修改完成后，新的用户信息
     */
    @PutMapping("/user/{uuid}")
    public ResultVo updateUserByUUID(@PathVariable("uuid") String uuid, @Validated(UpdateGroup.class) @RequestBody UserVo userVo,BindingResult result) throws VerificationException {
        if (result.hasErrors()) {
            Map<String, String> map = BindingResultCustomUtils.resultToMap(result);
            throw new VerificationException(UserResponseEnum.VERIFICATION_ERROR.getCode(), map);
        }
        UserDto userDtoNew = userService.updateUserByUUID(uuid, userVo);
        if (userDtoNew != null)
            return ResultVo.success().data(userDtoNew);
        throw new CustomGlobalException(UserResponseEnum.UPDATE_ERROR.getCode(), UserResponseEnum.UPDATE_ERROR.getMsg());
    }


}
