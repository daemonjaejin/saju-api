package com.saju.api.admin.entity;

import com.saju.api.comm.dto.PutEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CodePutEntity extends PutEntity {
    private String commonCodeId;
    private String groupCode;
    private String commonCode;
    private String commonCodeName;
    private String commonCodeOrder;
    private Integer useYn;
}
