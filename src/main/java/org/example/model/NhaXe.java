package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "nhaxe")
public class NhaXe {
    @Id
    @Column(name = "MaNhaXe", length = 20)
    private String maNhaXe;

    @Column(name = "TenNhaXe", length = 20)
    private String tenNhaXe;

    @Column(name = "NamThanhLap", length = 20)
    private String namThanhLap;

    @OneToMany(mappedBy = "nhaXe", cascade = CascadeType.ALL)
    private List<Xe> xes;

}
