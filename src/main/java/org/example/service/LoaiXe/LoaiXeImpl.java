package org.example.service.LoaiXe;

import org.example.model.LoaiXe;
import org.example.repository.LoaiXeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoaiXeImpl implements LoaiXeService{
    @Autowired
    private LoaiXeRepository repo;

    @Override
    public List<LoaiXe> findAll() {
        return repo.findAll();
    }
    @Override
    public Optional<LoaiXe> findById(String id) {
        return repo.findById(id);
    }
}
