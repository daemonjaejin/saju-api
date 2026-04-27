package com.saju.api.user.controller;

import com.saju.api.comm.dto.MapView;
import com.saju.api.user.dto.UserResult;
import com.saju.api.user.dto.UserViewModel;
import com.saju.api.user.entity.UserEntity;
import com.saju.api.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @RequestMapping(method = RequestMethod.POST, path = "/list")
    public MapView<UserViewModel> userList(@RequestBody(required = false) UserEntity entity){
        entity = (entity == null) ? new UserEntity() : entity;
        List<UserResult> userList = userService.userList(entity);
        int totalCnt = userService.userTotalCnt(entity);
        List<UserViewModel> userViewModelList = userList.stream()
                .map(UserViewModel::of)
                .collect(Collectors.toList());
        return MapView.<UserViewModel>builder()
                .content(userViewModelList)
                .totalCount(totalCnt)
                .page(entity.getPage())
                .size(entity.getSize())
                .build();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/detail")
    public UserViewModel userDetail(@RequestBody(required = false) UserEntity entity){
        UserResult userResult = userService.userDetail(entity);
        return UserViewModel.of(userResult);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/update")
    public int userUpdate(@RequestBody(required = false) UserEntity entity){
        return userService.userUpdate(entity);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/insert")
    public int userInsert(@RequestBody(required = false) UserEntity entity){
        return userService.userInsert(entity);
    }

}
