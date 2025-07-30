package com.chapinstore.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;

@Getter
@Setter
@ToString
@Builder
public class Pagination<T> {

    private Collection<T> content;
    private Integer totalPages;
    private Integer totalElements;
    private Integer size;
    private Integer page;

}
