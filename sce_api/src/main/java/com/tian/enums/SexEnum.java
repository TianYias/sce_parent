package com.tian.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SexEnum {

    MALE(0,"男"),
    FEMALE(1,"女");

    private final int sexNumber;
    private final String sex;

    public static String getSex(int sexNumber){
        for (SexEnum value : SexEnum.values()) {
            if(value.getSexNumber() == sexNumber){
                return value.getSex();
            }
        }
        return "";
    }
}
