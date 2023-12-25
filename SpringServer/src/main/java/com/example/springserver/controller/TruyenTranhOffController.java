package com.example.springserver.controller;

import com.example.springserver.dto.response.ResultDto;
import com.example.springserver.entity.truyen_off.TruyenOff;
import com.example.springserver.entity.truyen_onl.TruyenOnl;
import com.example.springserver.service.truyen_off.TruyenOffService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/truyen-tranh-off")
public class TruyenTranhOffController {
    private final TruyenOffService truyenOffService;
    @PostMapping("/save")
    public ResultDto save(@RequestBody TruyenOff truyenOff) {
        return truyenOffService.saveTruyen(truyenOff);
    }
    @GetMapping("/get-all")
    public List<TruyenOff> getAllEmployees() {
        return truyenOffService.showAll();
    }
}
