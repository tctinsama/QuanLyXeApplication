package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lichtrinhxe")
public class LichTrinhXe {

    @EmbeddedId
    private LichTrinhXeId id;

    @Column(name = "TenTaiXe")
    private String tenTaiXe;

    @ManyToOne
    @JoinColumn(name = "MaTuyen", referencedColumnName = "MaTuyen", insertable = false, updatable = false)
    private TuyenXe tuyenXe;


    @ManyToOne
    @JoinColumn(name = "MaXe", referencedColumnName = "MaXe", insertable = false, updatable = false)
    private Xe xe;

    @Column(name = "SoLuongHanhKhach")
    private Integer soLuongHanhKhach;

    // Inner static class cho khóa chính phức hợp
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public static class LichTrinhXeId implements Serializable {
        @Column(name = "MaXe",length = 20)
        private String maXe;

        @Column(name = "NgayXuatBen",length = 20)
        private LocalDateTime ngayXuatBen;

        @Column(name = "GioXuatBen",length = 20)
        private LocalDateTime gioXuatBen;


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof LichTrinhXeId)) return false;
            LichTrinhXeId that = (LichTrinhXeId) o;
            return Objects.equals(maXe, that.maXe)
                    && Objects.equals(ngayXuatBen, that.ngayXuatBen)
                    && Objects.equals(gioXuatBen, that.gioXuatBen);
        }

        @Override
        public int hashCode() {
            return Objects.hash(maXe, ngayXuatBen, gioXuatBen);
        }
    }

}
