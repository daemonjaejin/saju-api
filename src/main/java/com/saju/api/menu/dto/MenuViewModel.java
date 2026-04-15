package com.saju.api.menu.dto;

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
public class MenuViewModel extends CommonDto {
    private String menuId;
    private String menuParentId;
    private String menuName;
    private String menuUrl;

    public static MenuViewModel of(MenuResult result) {
        return MenuViewModel.builder()
                .menuId(result.getMenuId())
                .menuParentId(result.getMenuParentId())
                .menuName(result.getMenuName())
                .menuUrl(result.getMenuUrl())
                .useYn(result.getUseYn())
                .createDate(result.getCreateDate())
                .updateDate(result.getUpdateDate())
                .createUserId(result.getCreateUserId())
                .updateUserId(result.getUpdateUserId())
                .build();
    }
}
