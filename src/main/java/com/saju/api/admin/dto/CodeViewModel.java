package com.saju.api.admin.dto;

import com.saju.api.comm.dto.CommonDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CodeViewModel extends CommonDto {
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

    public static CodeViewModel of(CodeResult result) {
        return CodeViewModel.builder()
                .groupCode(result.getGroupCode())
                .groupCodeName(result.getGroupCodeName())
                .commonCode(result.getCommonCode())
                .commonCodeName(result.getCommonCodeName())
                .commonCodeOrder(result.getCommonCodeOrder())
                .emptyVal1(result.getEmptyVal1())
                .emptyVal2(result.getEmptyVal2())
                .emptyVal3(result.getEmptyVal3())
                .emptyVal4(result.getEmptyVal4())
                .emptyVal5(result.getEmptyVal5())
                .createDate(result.getCreateDate())
                .updateDate(result.getUpdateDate())
                .createUserId(result.getCreateUserId())
                .updateUserId(result.getUpdateUserId())
                .useYn(result.getUseYn())
                .commonCodeId(result.getCommonCodeId())
                .build();
    }
}
