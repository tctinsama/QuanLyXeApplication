package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface XeRepository extends JpaRepository<org.example.model.Xe, String> {

    @Query(value = """
        SELECT
            x.ma_xe,
            x.bien_so,
            lt.ten_tai_xe,
            nx.ten_nha_xe,
            lt.ma_tuyen,
            t.ten_tuyen,
            lt.ngay_xuat_ben,
            lt.gio_xuat_ben
        FROM lichtrinhxe lt
        JOIN xe x ON lt.ma_xe = x.ma_xe
        JOIN nhaxe nx ON x.ma_nha_xe = nx.ma_nha_xe
        JOIN tuyenxe t ON lt.ma_tuyen = t.ma_tuyen
        WHERE (:tenNhaXe IS NULL OR LOWER(nx.ten_nha_xe) LIKE CONCAT('%', LOWER(:tenNhaXe), '%'))
        ORDER BY lt.ngay_xuat_ben DESC, lt.gio_xuat_ben DESC
        """, nativeQuery = true)
    List<Object[]> findXeLichTrinhByTenNhaXeNative(@Param("tenNhaXe") String tenNhaXe);

}
