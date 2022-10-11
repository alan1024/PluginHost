package com.alan.pluginhost.model.bean.local;

/**
 * 支付方式bean
 */

public class BPay {

    private Long id;
    private String payName;
    private String payImg;

    private float income;
    private float outcome;

    public BPay() {
    }

    public BPay(Long id, String payName, String payImg, float income,
            float outcome) {
        this.id = id;
        this.payName = payName;
        this.payImg = payImg;
        this.income = income;
        this.outcome = outcome;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }

    public String getPayImg() {
        return payImg;
    }

    public void setPayImg(String payImg) {
        this.payImg = payImg;
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public float getOutcome() {
        return outcome;
    }

    public void setOutcome(float outcome) {
        this.outcome = outcome;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}