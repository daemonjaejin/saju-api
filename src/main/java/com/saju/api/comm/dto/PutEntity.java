package com.saju.api.comm.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public abstract class PutEntity {
    private String createUserId = "SYSTEM";
    private String updateUserId = "SYSTEM";
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        if (this.createDate == null) {
            this.createDate = now;
        }
        this.updateDate = now;

        // 필요시 여기서 "SYSTEM" 세팅을 강제로 다시 할 수도 있습니다.
        this.createUserId = "SYSTEM";
        this.updateUserId = "SYSTEM";
    }
}
