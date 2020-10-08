package com.samsung.bankservice.responsitory;

import com.samsung.bankservice.entity.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChucVuResponsitory  extends  JpaRepository<ChucVu, Integer>{
}
