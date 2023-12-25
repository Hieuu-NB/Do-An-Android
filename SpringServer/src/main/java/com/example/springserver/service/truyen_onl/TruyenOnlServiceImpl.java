package com.example.springserver.service.truyen_onl;

import com.example.springserver.dto.response.ResultDto;
import com.example.springserver.entity.truyen_onl.TrangTruyenOnl;
import com.example.springserver.entity.truyen_onl.TruyenOnl;
import com.example.springserver.repository.TrangTruyenOnlRepository;
import com.example.springserver.repository.TruyenOnlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TruyenOnlServiceImpl implements TruyenOnlService {
    private final TruyenOnlRepository truyenRepository;
    private final TrangTruyenOnlRepository trangTruyenOnlRepository;

    @Override
    public ResultDto saveTruyen(TruyenOnl truyenOnl) {
        try {
            truyenRepository.save(truyenOnl);
        }catch (Exception e){
            return ResultDto.builder().code(400).message(e.getMessage()).build();
        }
        return ResultDto.builder().code(200).message("thanh cong").build();
    }

    @Override
    public List<TruyenOnl> showAll() {
        return truyenRepository.findAll();
    }

    @Override
    public List<TrangTruyenOnl> listTrangTruyenOnl(Long tapTruyen) {
        return trangTruyenOnlRepository.listTrangTruyenOnl(tapTruyen);
    }
}
