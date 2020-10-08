package com.samsung.bankservice.responsitory;

import com.samsung.bankservice.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachhangReponsitory extends JpaRepository<KhachHang, Integer>{
    KhachHang findKhachHangByChungminhthu(String cmd);
    KhachHang findKhachHangByTenkhachhang(String name);
}
