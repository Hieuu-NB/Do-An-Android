package com.example.springserver.repository;

import com.example.springserver.entity.truyen_onl.TrangTruyenOnl;
import com.example.springserver.entity.truyen_onl.TruyenOnl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrangTruyenOnlRepository extends JpaRepository<TrangTruyenOnl, Long> {
    @Query(value = "SELECT * FROM trang_truyen_onl WHERE  truyen_id = :tapTruyen order by id", nativeQuery = true)
    List<TrangTruyenOnl> listTrangTruyenOnl(Long tapTruyen);
}
