package org.example.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tuyenxe")
public class TuyenXe {
    @Id
    @Column(name = "MaTuyen", length = 20)
    private String maTuyen;

    @Column(name = "TenTuyen", length = 20)
    private String tenTuyen;

    @Column(name = "DonGia")
    private Integer donGia ;

    @OneToMany(mappedBy = "tuyenXe", cascade = CascadeType.ALL)
    private List<LichTrinhXe> lichtrinhxes;
}
