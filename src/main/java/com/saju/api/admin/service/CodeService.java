package com.saju.api.admin.service;

import com.saju.api.admin.entity.CodeDelEntity;
import com.saju.api.admin.entity.CodeEntity;
import com.saju.api.admin.entity.CodePutEntity;
import com.saju.api.admin.dto.CodeResult;
import com.saju.api.admin.mapper.CodeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CodeService {

    @Autowired
    public final CodeMapper codeMapper;

    public List<CodeResult> codeList(CodeEntity entity) {
        return codeMapper.codeList(entity);
    }

    public long codeTotalCnt(CodeEntity entity) {
        return codeMapper.codeTotalCnt(entity);
    }

    @Transactional
    public int codeUpdate(CodePutEntity entity) {
        return codeMapper.codeUpdate(entity);
    }

    @Transactional
    public int codeInsert(CodePutEntity entity) {
        return codeMapper.codeInsert(entity);
    }

    @Transactional
    public int codeDelete(CodeDelEntity entity) {
        return codeMapper.codeDelete(entity);
    }

}
