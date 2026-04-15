package com.saju.api.menu.controller;

import com.saju.api.comm.dto.MapView;
import com.saju.api.menu.dto.MenuResult;
import com.saju.api.menu.dto.MenuViewModel;
import com.saju.api.menu.entity.MenuDelEntity;
import com.saju.api.menu.entity.MenuEntity;
import com.saju.api.menu.entity.MenuPutEntity;
import com.saju.api.menu.service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/menu")
public class MenuController {
    private final MenuService service;

    @RequestMapping(method = RequestMethod.POST, path = "/list")
    public MapView<MenuViewModel> menuList(@RequestBody(required = false) MenuEntity menuEntity){
        MenuEntity entity = (menuEntity == null) ? new MenuEntity() : menuEntity;
        List<MenuResult> menuList = service.menuList(entity);
        int totalCnt = service.menuTotalCnt(entity);
        List<MenuViewModel> viewModelList = menuList.stream()
                .map(MenuViewModel::of)
                .collect(Collectors.toList());
        return MapView.<MenuViewModel>builder()
                .content(viewModelList)
                .totalCount(totalCnt)
                .page(entity.getPage())
                .size(entity.getSize())
                .build();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/detail")
    public MenuViewModel menuDetail(@RequestBody(required = false) MenuEntity entity){
        MenuResult result = service.menuDetail(entity);
        return MenuViewModel.of(result);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/update")
    public int menuUpdate(@RequestBody(required = false) MenuPutEntity entity){
        return service.menuUpdate(entity);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/insert")
    public int codeInsert(@RequestBody(required = false) MenuPutEntity entity){
        return service.menuInsert(entity);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/delete")
    public int codeDelete(@RequestBody(required = false) MenuDelEntity entity){
        return service.menuDelete(entity);
    }
}
