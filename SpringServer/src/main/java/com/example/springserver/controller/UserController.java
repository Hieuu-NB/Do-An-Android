package com.example.springserver.controller;

import com.example.springserver.dto.response.ResultDto;
import com.example.springserver.entity.truyen_off.TruyenOff;
import com.example.springserver.service.truyen_off.TruyenOffService;
import com.example.springserver.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

        @GetMapping("/save")
        public ResultDto save(@RequestParam String tk,String mk) {
            return userService.saveAccount(tk,mk);
        }
        @GetMapping("/checkUser")
        public ResultDto checkUser(@RequestParam String tk,String mk) {
            return userService.checkUser(tk,mk);
        }

}
