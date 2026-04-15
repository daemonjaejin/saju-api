package com.saju.api.comm.dto;

import com.google.common.base.CaseFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public abstract class PageEntity {
    int page = 0;
    int size = 10;
    private String sortColumn;
    private String sortOrder;
    private List<String> dateRange;
    private String startDate;
    private String endDate;

    public int getOffset(){
        int currentPage = Math.max(this.page, 1);
        return (currentPage - 1) * size;
    }

    public void setPage(int page){
        this.page = Math.max(page, 1);
    }

    public String getOrderByClause() {
        if (this.sortColumn == null || this.sortColumn.trim().isEmpty() ||
                this.sortOrder == null || this.sortOrder.trim().isEmpty()) {
            return null;
        }

        if (!this.sortColumn.matches("^[a-zA-Z0-9_]*$")) {
            return null;
        }

        String finalColumn = this.sortColumn;

        // 언더바(_)가 없고, 대문자가 섞여 있는 경우(CamelCase)에만 변환을 실행합니다.
        if (!this.sortColumn.contains("_") && !this.sortColumn.equals(this.sortColumn.toUpperCase())) {
            finalColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, this.sortColumn);
        } else {
            // 이미 Snake Case거나 전부 대문자라면 그대로 사용 (단, 대문자로 통일은 해주는게 안전)
            finalColumn = this.sortColumn.toUpperCase();
        }

        String order = "DESC".equalsIgnoreCase(this.sortOrder) ? "DESC" : "ASC";
        return finalColumn + " " + order;
    }

    // 파라미터가 있는 Setter를 오버라이딩하여 자동 분리
    public void setDateRange(List<String> dateRange) {
        this.dateRange = dateRange;
        if (dateRange != null && dateRange.size() == 2) {
            this.startDate = dateRange.get(0);
            this.endDate = dateRange.get(1);
        }
    }
}
