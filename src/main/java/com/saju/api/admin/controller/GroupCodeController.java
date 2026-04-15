package com.saju.api.admin.controller;

import com.saju.api.admin.entity.GroupCodeEntity;
import com.saju.api.admin.dto.GroupCodeResult;
import com.saju.api.admin.dto.GroupCodeViewModel;
import com.saju.api.admin.service.GroupCodeService;
import com.saju.api.comm.dto.MapView;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/group")
public class GroupCodeController {

    @Autowired
    private final GroupCodeService service;

    @RequestMapping(method = RequestMethod.POST, path = "/list")
    public MapView<GroupCodeViewModel> groupList(@RequestBody(required = false) GroupCodeEntity entity){
        List<GroupCodeResult> groupCodeList = service.groupCodeList(entity);
        List<GroupCodeViewModel> viewModelList = groupCodeList.stream()
                .map(GroupCodeViewModel::of).collect(Collectors.toList());
        long totalCount = service.groupCodeTotalCnt(entity);
        return MapView.<GroupCodeViewModel>builder()
                .content(viewModelList)
                .totalCount(totalCount)
                .page(entity.getPage())
                .size(entity.getSize())
                .build();
    }
}
