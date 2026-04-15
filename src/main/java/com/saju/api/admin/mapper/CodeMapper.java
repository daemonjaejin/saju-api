package com.saju.api.admin.mapper;

import com.saju.api.admin.entity.CodeDelEntity;
import com.saju.api.admin.entity.CodeEntity;
import com.saju.api.admin.entity.CodePutEntity;
import com.saju.api.admin.dto.CodeResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CodeMapper {

    List<CodeResult> codeList(@Param("vo") CodeEntity entity);
    long codeTotalCnt(@Param("vo") CodeEntity entity);
    int codeUpdate(@Param("vo") CodePutEntity entity);
    int codeInsert(@Param("vo") CodePutEntity entity);
    int codeDelete(@Param("vo") CodeDelEntity entity);

}
