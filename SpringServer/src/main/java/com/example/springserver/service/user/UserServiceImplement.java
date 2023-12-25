package com.example.springserver.service.user;

import com.example.springserver.dto.response.ResultDto;
import com.example.springserver.entity.user.User;
import com.example.springserver.repository.TruyenOnlRepository;
import com.example.springserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService{
    private final UserRepository userRepository;
    @Override
    public ResultDto checkUser(String tk, String mk) {
        try {
            User x = userRepository.findUser(tk,mk);
            if (x == null){
                return ResultDto.builder().code(401).message("sai tai khoan hoac mat khau").build();
            }
        }catch (Exception e){
            return ResultDto.builder().code(400).message(e.getMessage()).build();
        }
        return ResultDto.builder().code(200).message("ok").build();
    }

    @Override
    public ResultDto saveAccount(String tk, String mk) {
        try {
            User x = new User();
            x.setTaiKhoan(tk);
            x.setMatKhau(mk);
            userRepository.save(x);
        }catch (Exception e){
            return ResultDto.builder().code(400).message(e.getMessage()).build();
        }
        return ResultDto.builder().code(200).message("thanh cong").build();
    }
}
