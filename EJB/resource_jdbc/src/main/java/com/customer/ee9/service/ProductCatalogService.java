package com.customer.ee9.service;

import com.customer.ee9.model.CatalogItem;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class ProductCatalogService {
    
    //состояние (кеш)
    private List<CatalogItem> items = new ArrayList<>();
    
    @PostConstruct
    public void init(){
        items.add(new CatalogItem("code1", "name1"));
        items.add(new CatalogItem("code2", "name2"));
    }
    
    @PreDestroy
    public void onDestroy(){
        items.clear();
    }
    
    public int getNumbersOfProducts() {
        return items.size();
    }
}
