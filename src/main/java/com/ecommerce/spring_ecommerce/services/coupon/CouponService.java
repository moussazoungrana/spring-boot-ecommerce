package com.ecommerce.spring_ecommerce.services.coupon;



import com.ecommerce.spring_ecommerce.entities.Coupon;

import java.util.List;

public interface CouponService {

    public List<Coupon> getAll();

    public Coupon findCouponById(Long id);

    public Coupon findCouponByCode(String code);

    public Coupon saveCoupon(Coupon coupon);

    public Coupon updateCoupon(Coupon coupon);


    public Boolean deleteCouponById(Long id);


}
