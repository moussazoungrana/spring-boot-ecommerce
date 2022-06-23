package com.ecommerce.spring_ecommerce.entities;

import javax.persistence.*;

@Entity
@Table(name = "coupons")
public class Coupon {

    public static final int FIXED_TYPE = 1;
    public static final int PERCENT_TYPE = 2;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "type", nullable = false)
    private int type = FIXED_TYPE;

    @Column(nullable = false)
    private float value;


    public Coupon(Long id, String code, int type, float value) {
        this.id = id;
        this.code = code;
        this.type = type;
        this.value = value;
    }

    public Coupon() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}