package com.example.springserver.entity.truyen_onl;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Table(name = "truyen_onl")
@RequiredArgsConstructor
@Data
public class TruyenOnl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String tenTruyen;
    private String tenChap;
    private String linkAnh;
    @OneToMany(mappedBy = "truyen",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<TrangTruyenOnl> listTruyen;

}
