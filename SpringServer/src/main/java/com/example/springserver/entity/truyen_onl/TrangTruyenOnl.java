package com.example.springserver.entity.truyen_onl;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "trang_truyen_onl")
@RequiredArgsConstructor
@Data
public class TrangTruyenOnl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String linkTrangTruyen;
    @ManyToOne
    @JoinColumn(name = "truyen_id" ,nullable = false,referencedColumnName = "id") // cột cart_id góống cột cartId bên cart
    @JsonBackReference
    private TruyenOnl truyen;

}
