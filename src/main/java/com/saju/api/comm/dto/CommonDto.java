package com.saju.api.comm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.sql.Date;

@Setter
@Getter
@NoArgsConstructor // SuperBuilder 사용 시 기본 생성자 필요
@AllArgsConstructor // SuperBuilder 사용 시 전체 생성자 필요
@SuperBuilder // 빌더 상속 활성화
public abstract class CommonDto {
    private String createUserId;
    private String updateUserId;
    private Date createDate;
    private Date updateDate;
    private int useYn;
}
