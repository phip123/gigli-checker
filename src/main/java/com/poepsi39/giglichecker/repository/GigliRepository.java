package com.poepsi39.giglichecker.repository;

import com.poepsi39.giglichecker.model.GigliStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GigliRepository extends JpaRepository<GigliStatus,Long> {
}
