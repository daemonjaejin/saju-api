package com.saju.api.admin.entity;

import com.saju.api.comm.dto.PageEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupCodeEntity extends PageEntity {
    private String groupCode;
    private String groupCodeName;
    private Integer useYn;
}
