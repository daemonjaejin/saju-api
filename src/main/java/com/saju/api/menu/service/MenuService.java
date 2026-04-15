package com.saju.api.menu.service;

import com.saju.api.menu.dto.MenuResult;
import com.saju.api.menu.entity.MenuDelEntity;
import com.saju.api.menu.entity.MenuEntity;
import com.saju.api.menu.entity.MenuPutEntity;
import com.saju.api.menu.mapper.MenuMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class MenuService {

    private final MenuMapper mapper;

    public List<MenuResult> menuList(MenuEntity entity) {
        return mapper.menuList(entity);
    }

    public int menuTotalCnt(MenuEntity entity) {
        return mapper.menuTotalCnt(entity);
    }

    public MenuResult menuDetail(MenuEntity entity) {
        return mapper.menuDetail(entity);
    }

    @Transactional
    public int menuUpdate(MenuPutEntity entity) {
        return mapper.menuUpdate(entity);
    }

    @Transactional
    public int menuInsert(MenuPutEntity entity) {
        return mapper.menuInsert(entity);
    }

    @Transactional
    public int menuDelete(MenuDelEntity entity) {
        return mapper.menuDelete(entity);
    }

}
