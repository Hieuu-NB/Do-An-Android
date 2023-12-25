package com.example.springserver.service.truyen_off;

import com.example.springserver.dto.response.ResultDto;
import com.example.springserver.entity.truyen_off.TruyenOff;
import com.example.springserver.entity.truyen_onl.TruyenOnl;

import java.util.List;

public interface TruyenOffService{
    ResultDto saveTruyen(TruyenOff truyenOff);
    List<TruyenOff> showAll();
}
