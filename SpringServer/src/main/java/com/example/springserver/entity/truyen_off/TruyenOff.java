package com.example.springserver.entity.truyen_off;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "truyen_off")
@RequiredArgsConstructor
@Data
public class TruyenOff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String tenTruyen;
    private String tapTruyen;
    private String noiDung;

}
