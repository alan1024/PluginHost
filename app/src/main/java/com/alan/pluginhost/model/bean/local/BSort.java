package com.alan.pluginhost.model.bean.local;


/**
 * 账单分类bean
 */

public class BSort{

    private Long id;
    private String sortName;
    private String sortImg;
    private float cost;
    private Boolean income;

    public BSort() {
    }

    public BSort(Long id, String sortName, String sortImg, float cost,
            Boolean income) {
        this.id = id;
        this.sortName = sortName;
        this.sortImg = sortImg;
        this.cost = cost;
        this.income = income;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getSortImg() {
        return sortImg;
    }

    public void setSortImg(String sortImg) {
        this.sortImg = sortImg;
    }

    public Boolean getIncome() {
        return income;
    }

    public void setIncome(Boolean income) {
        this.income = income;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}