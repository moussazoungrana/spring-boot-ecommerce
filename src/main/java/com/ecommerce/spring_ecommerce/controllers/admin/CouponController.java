package com.ecommerce.spring_ecommerce.controllers.admin;

import com.ecommerce.spring_ecommerce.entities.Coupon;
import com.ecommerce.spring_ecommerce.services.coupon.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/admin/coupons")
public class CouponController {

    @Autowired
    protected CouponService couponService;

    @GetMapping(value = "")
    public String index(Model model) {
        model.addAttribute("coupons", couponService.getAll());
        return "admin/coupons/index";
    }

    @GetMapping(value = "/create")
    public String create(Model model) {
        model.addAttribute("coupon", new Coupon());
        return "admin/coupons/create";
    }

    @PostMapping("/store")
    public String store(@ModelAttribute Coupon coupon) {
        couponService.saveCoupon(coupon);
        return "redirect:/admin/coupons";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Coupon coupon) {
        couponService.updateCoupon(coupon);
        return "redirect:/admin/coupons";
    }

    @GetMapping(value = "/{id}/edit")
    public String edit(Model model, @PathVariable long id) {
        Coupon coupon = couponService.findCouponById(id);
        model.addAttribute("coupon", coupon);
        return "admin/coupons/edit";
    }
}
