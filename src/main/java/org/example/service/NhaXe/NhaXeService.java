package org.example.service.LoaiXec.LoaiXe;

import org.example.model.NhaXe;

import java.util.List;
import java.util.Optional;


public interface NhaXeService {
    List<NhaXe> findAll();
    Optional<NhaXe> findById(String id);
}
