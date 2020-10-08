package com.samsung.bankservice.responsitory;

import com.samsung.bankservice.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienReponsitory  extends  JpaRepository<NhanVien, Integer> {
    NhanVien findByTennhanvien(String tennhanvien);
}
