package com.saju.api.user.service;

import com.saju.api.user.dto.UserResult;
import com.saju.api.user.entity.UserEntity;
import com.saju.api.user.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    public List<UserResult> userList(UserEntity entity){
        return userMapper.selectUserList(entity);
    }

    public int userTotalCnt(UserEntity entity){
        return userMapper.userTotalCnt(entity);
    }

    public UserResult userDetail(UserEntity entity){
        return userMapper.userDetail(entity);
    }

    @Transactional
    public int userUpdate(UserEntity entity){
        return userMapper.userUpdate(entity);
    }

    @Transactional
    public int userInsert(UserEntity entity){
        return userMapper.userInsert(entity);
    }

}
