package org.example.repository;

import org.example.model.Xe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface XeRepository extends JpaRepository<Xe, String> {
}
