package com.tian.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MessageEnum {

    INSERT_SCHOOL_SUCCESS("添加学校信息成功"),
    INSERT_SCHOOL_FAIL("添加学校信息失败"),
    DELETE_SCHOOL_SUCCESS("删除学校信息成功"),
    DELETE_SCHOOL_FAIL("删除学校信息失败"),
    UPDATE_SCHOOL_SUCCESS("修改学校信息成功"),
    UPDATE_SCHOOL_FAIL("修改学校信息失败"),
    QUERY_ALL_SCHOOL_SUCCESS("查询全部学校成功"),
    QUERY_ALL_SCHOOL_FAIL("查询全部学校失败"),
    ;

    private final String message;
}
