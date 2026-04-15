package com.saju.api.menu.entity;

import com.saju.api.comm.dto.PageEntity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MenuEntity extends PageEntity {
    private String menuId;
    private String menuParentId;
    private String menuName;
    private String menuUrl;
    private Integer useYn;
}
