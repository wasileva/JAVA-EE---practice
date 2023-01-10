package com.customer.ee9.model;

public class CatalogItem {
    
    String code;
    String name;
    
    public CatalogItem(){}

    public CatalogItem(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
     
}
