package com.saju.api.admin.mapper;

import com.saju.api.admin.entity.GroupCodeEntity;
import com.saju.api.admin.dto.GroupCodeResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GroupCodeMapper {

    List<GroupCodeResult> groupCodeList(@Param("vo") GroupCodeEntity entity);
    long groupCodeTotalCnt(@Param("vo") GroupCodeEntity entity);

}
