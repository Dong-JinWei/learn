package com.dowei.phonesys;

public class Phone {
    private Integer phoneId;
    private String phoneBrand;
    private String phoneModel;
    private String phoneName;
    private Double phonePrice;

    public Phone() {
    }

    public Phone(Integer phoneId, String phoneBrand, String phoneModel, String phoneName, double phonePrice) {
        this.phoneId = phoneId;
        this.phoneBrand = phoneBrand;
        this.phoneModel = phoneModel;
        this.phoneName = phoneName;
        this.phonePrice = phonePrice;
    }

    public Integer getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Integer phoneId) {
        this.phoneId = phoneId;
    }

    public String getPhoneBrand() {
        return phoneBrand;
    }

    public void setPhoneBrand(String phoneBrand) {
        this.phoneBrand = phoneBrand;
    }

    public String getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public double getPhonePrice() {
        return phonePrice;
    }

    public void setPhonePrice(double phonePrice) {
        this.phonePrice = phonePrice;
    }

    @Override
    public String toString() {
        return "ID：" + phoneId +
                "\n品牌：" + phoneBrand +
                "\n型号：" + phoneModel +
                "\n名称：" + phoneName +
                "\n价格：" + phonePrice;
    }
}
