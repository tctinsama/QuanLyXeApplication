package org.example.service.Xe;

import org.example.dto.resp.XeLichTrinhInfoResp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.example.model.Xe;

import java.util.List;
import java.util.Optional;

public interface XeService {
    List<Xe> findAll();
    Optional<Xe> findById(String id);
    Xe save(Xe xe);
    Xe update(String id, Xe xe);
    void deleteById(String id);
    List<XeLichTrinhInfoResp> getXeLichTrinh(String tenNhaXe);

    Page<Xe> findAll(Pageable pageable);
}
