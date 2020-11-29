package com.example.agriculture.Mandi;

public class Pojo {
    String primaryItem,region,contactDetails,contactNumber,partner,productDetails,endProducts;

    public String getPrimaryItem() {
        return primaryItem;
    }

    public String getRegion() {
        return region;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getPartner() {
        return partner;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public String getEndProducts() {
        return endProducts;
    }

    public Pojo() {
    }

    public Pojo(String primaryItem, String region, String contactDetails, String contactNumber, String partner, String productDetails, String endProducts) {
        this.primaryItem = primaryItem;
        this.region = region;
        this.contactDetails = contactDetails;
        this.contactNumber = contactNumber;
        this.partner = partner;
        this.productDetails = productDetails;
        this.endProducts = endProducts;
    }
}
