package com.samsung.bankservice.responsitory;

import com.samsung.bankservice.entity.GiaoDichThe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiaoDichTheResponsitory extends JpaRepository<GiaoDichThe,Integer> {
}
