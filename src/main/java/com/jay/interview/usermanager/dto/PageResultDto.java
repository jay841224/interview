package com.jay.interview.usermanager.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageResultDto<T> {

    @Schema(description = "query contents")
    private List<T> content;

    @Schema(description = "number of content")
    private int totalElements;

    @Schema(description = "total pages of contents")
    private int totalPages;

    @Schema(description = "current page")
    private int number;

    @Schema(description = "size of page")
    private int size;
}
