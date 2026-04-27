package com.saju.api.user.dto;

import com.saju.api.comm.dto.CommonDto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserResult extends CommonDto {
    private String userId;
    private String userName;
    private String genderCodeName;
    private String genderCode;
    private String address;
    private String phone;
    private String starSign;
    private String status;
    private String password;
}
