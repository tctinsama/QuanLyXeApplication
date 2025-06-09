package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "xe")
public class Xe {
    @Id
    @Column(name="MaXe" , length = 20)
    private String maXe;

    @Column(name="HangSanXuat" , length = 20)
    private String hangSanXuat;

    @Column(name="MaLoaiXe", length = 20)
    private String maLoaiXe;

    @ManyToOne
    @JoinColumn(name = "MaLoaiXe", referencedColumnName = "MaLoaiXe", insertable = false, updatable = false)
    private LoaiXe loaiXe;

    @Column(name="BienSo" , length = 20)
    private String bienSo;

    @Column(name="HanKiemDinh" , length = 20)
    private LocalDateTime hanKiemDinh;

    @Column(name="MaNhaXe", length = 20)
    private String maNhaXe;

    @ManyToOne
    @JoinColumn(name = "MaNhaXe", referencedColumnName = "MaNhaXe", insertable = false, updatable = false)
    private NhaXe nhaXe;

    @OneToMany(mappedBy = "xe", cascade = CascadeType.ALL)
    private List<LichTrinhXe> lichtrinhxes;
}
