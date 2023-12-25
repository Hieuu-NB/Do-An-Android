package com.example.springserver.service.truyen_off;

import com.example.springserver.dto.response.ResultDto;
import com.example.springserver.entity.truyen_off.TruyenOff;
import com.example.springserver.entity.truyen_onl.TruyenOnl;
import com.example.springserver.repository.TruyenOffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TruyenOffServiceImpl implements TruyenOffService{
    private final TruyenOffRepository truyenOffRepository;
    @Override
    public ResultDto saveTruyen(TruyenOff truyenOff) {
        try {
            truyenOffRepository.save(truyenOff);
        }catch (Exception e){
            return ResultDto.builder().code(400).message(e.getMessage()).build();
        }
        return ResultDto.builder().code(200).message("thanh cong").build();
    }



    @Override
    public List<TruyenOff> showAll() {
        return truyenOffRepository.findAll();
    }
}
