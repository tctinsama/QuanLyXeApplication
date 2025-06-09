package org.example.service.Xe;

import org.example.model.Xe;

import java.util.List;

public interface XeService {
    Xe save(Xe xe);
    List<Xe> findAll();
}
