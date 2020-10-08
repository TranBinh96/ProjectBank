package com.samsung.bankservice.responsitory;

import com.samsung.bankservice.entity.TaiKhoanTietKiem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaiKhoanTietKiemReponsitory extends JpaRepository<TaiKhoanTietKiem, Integer> {
}
