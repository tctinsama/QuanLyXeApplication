package org.example.service.LoaiXe;

import org.example.model.LoaiXe;

import java.util.List;
import java.util.Optional;


public interface LoaiXeService {
    List<LoaiXe> findAll();
    Optional<LoaiXe> findById(String id);
}
