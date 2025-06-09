package org.example.service.LoaiXec.LoaiXe;

import org.example.model.NhaXe;
import org.example.repository.NhaXeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhaXeImpl implements NhaXeService {
    @Autowired
    private NhaXeRepository repo;

    @Override
    public List<NhaXe> findAll() {
        return repo.findAll();
    }
    @Override
    public Optional<NhaXe> findById(String id) {
        return repo.findById(id);
    }
}
