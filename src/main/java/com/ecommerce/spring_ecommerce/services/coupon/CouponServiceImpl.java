package com.ecommerce.spring_ecommerce.services.coupon;

import com.ecommerce.spring_ecommerce.entities.Coupon;
import com.ecommerce.spring_ecommerce.repositories.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponRepository couponRepository;

    @Override
    public List<Coupon> getAll() {
        return couponRepository.findAll();
    }

    @Override
    public Coupon findCouponById(Long id) {
        return couponRepository.findById(id).orElse(null);
    }

    @Override
    public Coupon findCouponByCode(String code) {
        return couponRepository.findByCode(code);
    }

    @Override
    public Coupon saveCoupon(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    @Override
    public Coupon updateCoupon(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    @Override
    public Boolean deleteCouponById(Long id) {
        if (this.findCouponById(id) == null) {
            return false;
        }
        couponRepository.deleteById(id);
        return true;
    }
}
