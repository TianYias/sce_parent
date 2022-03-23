package com.tian.service;

import com.tian.dto.LoginDTO;
import com.tian.entity.Result;

public interface LoginService {

    public Result login(LoginDTO loginDTO);
}
