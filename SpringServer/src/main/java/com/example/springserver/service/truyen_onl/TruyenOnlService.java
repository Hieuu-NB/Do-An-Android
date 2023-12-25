package com.example.springserver.service.truyen_onl;

import com.example.springserver.dto.response.ResultDto;
import com.example.springserver.entity.truyen_onl.TrangTruyenOnl;
import com.example.springserver.entity.truyen_onl.TruyenOnl;

import java.util.List;

public interface TruyenOnlService {
    ResultDto saveTruyen(TruyenOnl truyenOnl);
    List<TruyenOnl> showAll();
    List<TrangTruyenOnl> listTrangTruyenOnl(Long tapTruyen);
}
