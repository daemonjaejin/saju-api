package com.saju.api.admin.dto;

import com.saju.api.comm.dto.CommonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class GroupCodeViewModel extends CommonDto {
    private String groupCodeId;
    private String groupCode;
    private String groupCodeName;
    private String description;

    public static GroupCodeViewModel of(GroupCodeResult result) {
        return GroupCodeViewModel.builder()
                .groupCodeId(result.getGroupCodeId())
                .groupCode(result.getGroupCode())
                .groupCodeName(result.getGroupCodeName())
                .description(result.getDescription())
                .createDate(result.getCreateDate())
                .updateDate(result.getUpdateDate())
                .createUserId(result.getCreateUserId())
                .updateUserId(result.getUpdateUserId())
                .useYn(result.getUseYn())
                .build();
    }
}
