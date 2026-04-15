package com.saju.api.comm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MapView<T> {
    private List<T> content;
    private long totalCount;
    private int page;
    private int size;
}
