package com.saju.api.menu.mapper;

import com.saju.api.menu.dto.MenuResult;
import com.saju.api.menu.entity.MenuDelEntity;
import com.saju.api.menu.entity.MenuEntity;
import com.saju.api.menu.entity.MenuPutEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuMapper {
    List<MenuResult> menuList(@Param("vo") MenuEntity entity);
    int menuTotalCnt(@Param("vo") MenuEntity entity);
    MenuResult menuDetail(@Param("vo") MenuEntity entity);
    int menuUpdate(@Param("vo") MenuPutEntity entity);
    int menuInsert(@Param("vo") MenuPutEntity entity);
    int menuDelete(@Param("vo") MenuDelEntity entity);
}
