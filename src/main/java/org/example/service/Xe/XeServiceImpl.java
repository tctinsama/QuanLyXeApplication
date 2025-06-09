package org.example.service.Xe;

import org.example.repository.XeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.example.model.Xe;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class XeServiveImpl {
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

//    @Override
//    public Page<Xe> search(String keyword, Pageable pageable) {
//        return repo.findByMaDVContainingOrTenDVContaining(keyword, keyword, pageable);
//    }

}
