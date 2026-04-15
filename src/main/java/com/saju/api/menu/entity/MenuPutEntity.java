package com.saju.api.menu.entity;

import com.saju.api.comm.dto.PutEntity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MenuPutEntity extends PutEntity {
    private String menuParentId;
    private String menuId;
    private String menuName;
    private String menuUrl;
    private String useYn;
}
