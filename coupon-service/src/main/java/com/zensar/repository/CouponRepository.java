package com.zensar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.entity.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {
	

}
