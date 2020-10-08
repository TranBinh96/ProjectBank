package com.samsung.bankservice.responsitory;

import com.samsung.bankservice.entity.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaiKhoanResponsitory extends JpaRepository<TaiKhoan, Integer> {

}
