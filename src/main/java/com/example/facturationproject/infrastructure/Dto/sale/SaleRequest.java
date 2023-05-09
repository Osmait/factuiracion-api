package com.example.facturationproject.infrastructure.Dto.sale;

import com.example.facturationproject.domain.Sale.Sale;
import lombok.Data;

@Data
public class SaleRequest {


    private String description;

    private Double price;

    private Long ClientId;

    public Sale ToSale() {
       Sale sale =  new Sale();
       sale.setDescription(description);
       sale.setPrice(price);
       return  sale;
    }
}
