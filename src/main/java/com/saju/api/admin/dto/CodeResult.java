package com.saju.api.admin.dto;

import com.saju.api.comm.dto.CommonDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CodeResult extends CommonDto {
    private String commonCodeId;
    private String groupCode;
    private String groupCodeName;
    private String commonCode;
    private String commonCodeName;
    private String commonCodeOrder;
    private String emptyVal1;
    private String emptyVal2;
    private String emptyVal3;
    private String emptyVal4;
    private String emptyVal5;
}
