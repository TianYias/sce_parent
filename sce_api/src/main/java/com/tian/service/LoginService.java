package com.tian.service;

import com.tian.dto.LoginDTO;
import com.tian.entity.Result;

public interface LoginService {

    public Result login(LoginDTO loginDTO);

//    public boolean existence(Object loginId);

    String getPasswordById(String loginNumber, String longinType);
}
