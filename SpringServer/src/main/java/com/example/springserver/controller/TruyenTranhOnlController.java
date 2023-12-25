package com.example.springserver.controller;

import com.example.springserver.dto.response.ResultDto;
import com.example.springserver.entity.truyen_onl.TrangTruyenOnl;
import com.example.springserver.entity.truyen_onl.TruyenOnl;
import com.example.springserver.service.truyen_onl.TruyenOnlService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/truyen-tranh-onl")
public class TruyenTranhOnlController {
    private final TruyenOnlService truyenService;
    @PostMapping("/save")
    public ResultDto save(@RequestBody TruyenOnl truyenOnl) {
        return truyenService.saveTruyen(truyenOnl);
    }
    @GetMapping("/get-all")
    public List<TruyenOnl> getAllEmployees() {
        return truyenService.showAll();
    }
    @GetMapping("/get-by-id")
    public List<TrangTruyenOnl> getTrangTruyenById(@RequestParam Long tapTruyen) {
        return truyenService.listTrangTruyenOnl(tapTruyen);
    }
//    @GetMapping("/get-by-id")
//    public ResultDto checkUser(@RequestParam Long tapTruyen) {
//        return truyenService.listTrangTruyenOnl(tapTruyen);
//        return null;
//    }
}
