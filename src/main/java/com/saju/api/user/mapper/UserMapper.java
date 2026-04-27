package com.saju.api.user.mapper;

import com.saju.api.user.dto.UserResult;
import com.saju.api.user.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserResult> selectUserList(@Param("vo") UserEntity vo);
    int userTotalCnt(@Param("vo") UserEntity vo);
    UserResult userDetail(@Param("vo") UserEntity vo);
    int userUpdate(@Param("vo") UserEntity vo);
    int userInsert(@Param("vo") UserEntity vo);
}
