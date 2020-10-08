package com.samsung.bankservice.responsitory;

import com.samsung.bankservice.entity.TaiKhoanTinDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaiKhoanTinDungReponsitory extends JpaRepository<TaiKhoanTinDung, Integer> {
}
