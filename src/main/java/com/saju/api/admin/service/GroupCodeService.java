package com.saju.api.admin.service;

import com.saju.api.admin.entity.GroupCodeEntity;
import com.saju.api.admin.dto.GroupCodeResult;
import com.saju.api.admin.mapper.GroupCodeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GroupCodeService {

    private final GroupCodeMapper mapper;

    public List<GroupCodeResult> groupCodeList(GroupCodeEntity entity){
        return mapper.groupCodeList(entity);
    }

    public long groupCodeTotalCnt(GroupCodeEntity entity){
        return mapper.groupCodeTotalCnt(entity);
    }

}
