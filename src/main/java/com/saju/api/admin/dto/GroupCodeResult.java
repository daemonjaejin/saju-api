package com.saju.api.admin.dto;

import com.saju.api.comm.dto.CommonDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupCodeResult extends CommonDto {
    private String groupCodeId;
    private String groupCode;
    private String groupCodeName;
    private String description;
}
