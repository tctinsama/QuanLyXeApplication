package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Xe {

    @Id
    private String bienSoXe;

    private LocalDate hanKiemDinh;

    public Xe() {
    }

    public Xe(String bienSoXe, LocalDate hanKiemDinh) {
        this.bienSoXe = bienSoXe;
        this.hanKiemDinh = hanKiemDinh;
    }

    public String getBienSoXe() {
        return bienSoXe;
    }

    public void setBienSoXe(String bienSoXe) {
        this.bienSoXe = bienSoXe;
    }

    public LocalDate getHanKiemDinh() {
        return hanKiemDinh;
    }

    public void setHanKiemDinh(LocalDate hanKiemDinh) {
        this.hanKiemDinh = hanKiemDinh;
    }
}
