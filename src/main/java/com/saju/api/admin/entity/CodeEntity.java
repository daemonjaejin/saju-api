package com.saju.api.admin.entity;

import com.saju.api.comm.dto.PageEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CodeEntity extends PageEntity {
    private String groupCode;
    private String groupCodeName;
    private String commonCodeName;
    private Integer useYn;
    private List<String> groupCodeNameList;
    private List<String> commonCodeNameList;
}
