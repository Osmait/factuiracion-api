package com.example.facturationproject.infrastructure.Dto.sale;

import com.example.facturationproject.domain.Sale.Sale;

public class SaleRequest {


    private String description;

    private String price;

    private Long ClientId;

    public Sale ToSale() {
       Sale sale =  new Sale();
       sale.setDescription(description);
       sale.setPrice(price);
       return  sale;
    }
}
