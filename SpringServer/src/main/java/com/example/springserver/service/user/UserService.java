package com.example.springserver.service.user;

import com.example.springserver.dto.response.ResultDto;
import com.example.springserver.entity.truyen_onl.TruyenOnl;
import com.example.springserver.entity.user.User;

public interface UserService {
    ResultDto checkUser(String tk, String mk);
    ResultDto saveAccount(String tk, String mk);
}
