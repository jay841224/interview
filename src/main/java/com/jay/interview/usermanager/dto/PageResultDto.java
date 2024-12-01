package com.jay.interview.usermanager.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageResultDto<T> {

    private List<T> content;

    private int totalElements;

    private int totalPages;

    private int number;

    private int size;
}
