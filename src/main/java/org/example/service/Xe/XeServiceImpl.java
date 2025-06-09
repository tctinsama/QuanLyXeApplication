package org.example.service.Xe;

import org.example.dto.resp.XeLichTrinhInfoResp;
import org.example.repository.XeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.example.model.Xe;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.util.StringUtils;


import java.sql.Timestamp;

import java.time.ZoneId;


@Service
public class XeServiceImpl implements XeService {
    @Autowired
    private XeRepository repo;

    @Override
    public List<Xe> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Xe> findById(String id) {
        return repo.findById(id);
    }

    @Override
    public Xe save(Xe xe) {
        LocalDateTime now = LocalDateTime.now();
        if (xe.getHanKiemDinh() == null || xe.getHanKiemDinh().isBefore(now.plusMonths(1))) {
            throw new IllegalArgumentException(
                    "Han kiem dinh khong dung, han kiem dinh phai lon hon thoi gian hien tai la 1 thang, xin hay nhap lai thong tin han kiem dinh"
            );
        }
        return repo.save(xe);
    }
    @Override
    public Xe update(String id, Xe xe) {
        if (repo.existsById(id)) {
            xe.setMaXe(id);
            return repo.save(xe);
        } else {
            throw new RuntimeException("DichVu not found!");
        }
    }

    @Override
    public void deleteById(String id) {
        repo.deleteById(id);
    }

    @Override
    public Page<Xe> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Autowired
    private XeRepository xeRepository;

    @Override
    public List<XeLichTrinhInfoResp> getXeLichTrinh(String tenNhaXe) {
        // Nếu tìm kiếm rỗng hoặc null thì truyền null cho query
        if (!StringUtils.hasText(tenNhaXe)) {
            tenNhaXe = null;
        }
        List<Object[]> results = xeRepository.findXeLichTrinhByTenNhaXeNative(tenNhaXe);
        List<XeLichTrinhInfoResp> dtos = new ArrayList<>();
        for (Object[] row : results) {
            String maXe = (String) row[0];
            String bienSo = (String) row[1];
            String tenTaiXe = (String) row[2];
            String tenNhaXeResult = (String) row[3];
            String maTuyen = (String) row[4];
            String tenTuyen = (String) row[5];

            // Chuyển string ngày giờ thành LocalDate, LocalTime
            LocalDate ngayXuatBen = row[6] != null ? LocalDate.parse(row[6].toString()) : null;
            LocalTime gioXuatBen = row[7] != null ? LocalTime.parse(row[7].toString()) : null;

            dtos.add(new XeLichTrinhInfoResp(maXe, bienSo, tenTaiXe, tenNhaXeResult, maTuyen, tenTuyen, ngayXuatBen, gioXuatBen));
        }
        return dtos;
    }
    //@Override
//    public Page<Xe> search(String keyword, Pageable pageable) {
//        return repo.findByMaDVContainingOrTenDVContaining(keyword, keyword, pageable);
//    }

}
