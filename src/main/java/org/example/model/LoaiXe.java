package org.example.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "loaixe")
public class LoaiXe {
    @Id
    @Column(name = "MaLoaiXe", length = 20)
    private String maLoaiXe;

    @Column(name = "MoTaLoaiXe", length = 20)
    private String moTaLoaiXe;

    @Column(name = "SoLuongChoNgoi", length = 20)
    private Integer soLuongChoNgoi;

    @OneToMany(mappedBy = "loaiXe", cascade = CascadeType.ALL)
    private List<Xe> xes;

}
