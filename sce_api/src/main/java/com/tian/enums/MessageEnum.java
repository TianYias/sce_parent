package com.tian.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MessageEnum {

    QUERY_ALL_SCHOOL_SUCCESS("查询全部学校成功"),
    QUERY_ALL_SCHOOL_FAIL("查询全部学校失败"),

    ;

    private final String message;
}
