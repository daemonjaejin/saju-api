package com.saju.api.user.entity;

import com.saju.api.comm.dto.PageEntity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserEntity extends PageEntity {
    private String userId;
    private String userName;
    private String genderCode;
    private String status;
    private String useYn;
}
