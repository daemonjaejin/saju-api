package com.saju.api.menu.dto;

import com.saju.api.comm.dto.CommonDto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MenuResult extends CommonDto {
    private String menuId;
    private String menuParentId;
    private String menuName;
    private String menuUrl;
}
