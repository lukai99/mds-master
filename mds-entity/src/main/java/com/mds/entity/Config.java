package com.mds.entity;

public class Config {
    private String id;

    private String discount;

    public Config(String id, String discount) {
        this.id = id;
        this.discount = discount;
    }

    public Config() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount == null ? null : discount.trim();
    }
}