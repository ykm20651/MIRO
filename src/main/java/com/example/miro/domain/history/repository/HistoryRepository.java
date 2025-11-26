package com.example.miro.domain.history.repository;

import com.example.miro.domain.history.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History,Long> {
}
