package org.example.service.Xe;

import org.example.model.Xe;
import org.example.repository.XeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class XeServiceImpl implements XeService {

    @Autowired
    private XeRepository repo;

    @Override
    public Xe save(Xe xe) {
        LocalDate now = LocalDate.now();
        if (xe.getHanKiemDinh() == null ||
                ChronoUnit.MONTHS.between(now, xe.getHanKiemDinh()) < 1) {
            throw new IllegalArgumentException("Han kiem dinh khong dung, han kiem dinh phai lon hon thoi gian hien tai la 1 thang, xin hay nhap lai thong tin han kiem dinh");
        }
        return repo.save(xe);
    }

    @Override
    public List<Xe> findAll() {
        return repo.findAll();
    }
}
