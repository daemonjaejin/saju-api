package com.saju.api.comm.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public abstract class PutEntity {
    private String createUserId = "SYSTEM";
    private String updateUserId = "SYSTEM";

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 형식을 다시 시분초 포함으로 돌려놓고
    private LocalDateTime createDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 형식을 다시 시분초 포함으로 돌려놓고
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
