package com.example.springserver.repository;

import com.example.springserver.entity.truyen_off.TruyenOff;
import com.example.springserver.entity.truyen_onl.TruyenOnl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TruyenOffRepository extends JpaRepository<TruyenOff, Long> {

}
