package com.saju.api.user.dto;

import com.saju.api.comm.dto.CommonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UserViewModel extends CommonDto {
    private String userId;
    private String userName;
    private String genderCodeName;
    private String genderCode;
    private String address;
    private String phone;
    private String starSign;
    private String status;
    private String password;

    public static UserViewModel of(UserResult result) {
        return UserViewModel.builder()
                .userId(result.getUserId())
                .userName(result.getUserName())
                .genderCodeName(result.getGenderCodeName())
                .genderCode(result.getGenderCode())
                .address(result.getAddress())
                .phone(result.getPhone())
                .starSign(result.getStarSign())
                .status(result.getStatus())
                .password(result.getPassword())
                .useYn(result.getUseYn())
                .build();
    }
}
