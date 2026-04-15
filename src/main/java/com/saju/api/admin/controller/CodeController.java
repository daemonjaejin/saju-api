package com.saju.api.admin.controller;

import com.saju.api.admin.dto.*;
import com.saju.api.admin.entity.CodeDelEntity;
import com.saju.api.admin.entity.CodeEntity;
import com.saju.api.admin.entity.CodePutEntity;
import com.saju.api.admin.service.CodeService;
import com.saju.api.comm.dto.MapView;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/code")
public class CodeController {
    private final CodeService codeService;

    @RequestMapping(method = RequestMethod.POST, path = "/list")
    public MapView<CodeViewModel> codeList(@RequestBody(required = false) CodeEntity codeEntity){
        CodeEntity entity = (codeEntity == null) ? new CodeEntity() : codeEntity;
        List<CodeResult> codeList = codeService.codeList(entity);
        List<CodeViewModel> viewModelList = codeList.stream()
                .map(CodeViewModel::of)
                .collect(Collectors.toList());
        long totalCount = codeService.codeTotalCnt(entity);
        return MapView.<CodeViewModel>builder()
                .content(viewModelList)
                .totalCount(totalCount)
                .page(entity.getPage())
                .size(entity.getSize())
                .build();
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/update")
    public int codeUpdate(@RequestBody(required = false) CodePutEntity entity){
        return codeService.codeUpdate(entity);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/insert")
    public int codeInsert(@RequestBody(required = false) CodePutEntity entity){
        return codeService.codeInsert(entity);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/delete")
    public int codeDeletes(@RequestBody(required = false) CodeDelEntity entity){
        return codeService.codeDelete(entity);
    }
}
